package com.liyuan.component.jwt;

import com.liyuan.service.PermissionServiceImpl;
import com.liyuan.service.RoleServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties({JwtProperties.class})
@ConditionalOnProperty(prefix = "jwt.config", name = "enabled", matchIfMissing = true, havingValue = "true")
@Configuration
public class JwtConfiguration {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PermissionServiceImpl permissionService;
    @Autowired
    private RoleServiceImpl roleService;

    @Bean
    public JwtTokenGenerator jwtTokenGenerator(JwtProperties jwtProperties) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyStoreException, InvalidKeySpecException {
        return new JwtTokenGenerator(new JwtPayloadBuilder(), jwtProperties);
    }

    /**
     * 既然能登陆成功了，那肯定能够查到该用户
     *
     * @return
     */
    @Bean
    public AuthenticationSuccessHandler jsonAuthenticationSuccessHandler(JwtTokenGenerator jwtTokenGenerator) {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//                MallUser mallUser = userService.queryByUsername(userDetails.getUsername(), MallUser.Column.id, MallUser.Column.role);
                //我觉得还是将该用户的role放置在token里比较好，或者干脆只放置用户名，
                Map<String, String> additional = new HashMap<>();
                additional.put("ip", request.getRemoteAddr());
                JwtTokenPair jwtTokenPair = jwtTokenGenerator.jwtTokenPairWithUsername(userDetails.getUsername(), null, additional);
                String build = ResponseUtils.build(HttpStatus.OK.value(), "登录成功！", jwtTokenPair);
                ResponseUtils.printJson(response, build);
            }
        };
    }

    @Bean
    public AuthenticationFailureHandler jsonAuthenticationFailureHandler() {
        return new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                String build = ResponseUtils.build(HttpStatus.BAD_REQUEST.value(), "用户名或密码错误！");
                ResponseUtils.printJson(response, build);
            }
        };
    }

}
