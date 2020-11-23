package com.liyuan.component.security;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liyuan.component.jwt.JwtTokenGenerator;
import com.liyuan.exception.JwtTokenMissingAuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTHENTICATION_PREFIX = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;


    //依赖注入优先
    public JwtAuthenticationFilter(AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            String header = httpServletRequest.getHeader(AUTHORIZATION);
            if (StringUtils.hasText(header) && header.startsWith(AUTHENTICATION_PREFIX)) {
                String jwt = header.substring(AUTHENTICATION_PREFIX.length());
                if (StringUtils.hasText(jwt)) {
                    resolve(jwt, httpServletRequest);
                } else {
                    authenticationEntryPoint.commence(httpServletRequest, httpServletResponse, new JwtTokenMissingAuthenticationException("token部分丢失！"));
                }
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    private void resolve(String jwt, HttpServletRequest httpServletRequest) {
        String json = jwtTokenGenerator.decodeAndVerify(jwt);
        JSONObject jsonObject = (JSONObject) JSONObject.parse(json);
        LocalDateTime expirationDatetime = LocalDateTime.parse((String) jsonObject.get("expiration"));
        if (LocalDateTime.now().isAfter(expirationDatetime)) {
            throw new AuthenticationServiceException("token 过期！");
        }
        //此处解析该token
        JSONArray roles = jsonObject.getJSONArray("roles");
        Collection<GrantedAuthority> authorities = new LinkedList<>();
        for (Object role : roles) {
            String next = (String) role;
            authorities.add(new SimpleGrantedAuthority("ROLE_" + next));
            //TODO 获取该用户所拥有的权限
        }
        String username = jsonObject.getString("audience");
        User user = new User(username, "[PASSWORD]", authorities);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, authorities);
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

}
