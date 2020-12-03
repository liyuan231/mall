package com.liyuan.configuration;

import com.liyuan.component.security.JsonUsernamePasswordAuthenticationFilter;
import com.liyuan.component.security.JwtAuthenticationFilter;
import com.liyuan.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)
public class SpringSecurityConfiguration {
    private static Logger logger = LoggerFactory.getLogger(SpringSecurityConfiguration.class);

    @Bean
    @Primary
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean

    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Configuration
    @Order(1)
    public static class ClientSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        @Qualifier("userServiceImpl")
        private UserDetailsService userService;
        @Autowired
        private AuthenticationFailureHandler authenticationFailureHandler;
        @Autowired
        private AuthenticationSuccessHandler authenticationSuccessHandler;
        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean("clientJsonUsernamePasswordAuthenticationFilter")
        public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() throws Exception {
            JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter();
            filter.setAuthenticationManager(authenticationManagerBean());
            filter.setFilterProcessesUrl("/client/login");
            filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
            filter.setAuthenticationFailureHandler(authenticationFailureHandler);
            return filter;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            http.addFilterAt(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            http.csrf().disable().
                    antMatcher("/client/**").formLogin()
                    .and().authorizeRequests().anyRequest().permitAll();
            http.userDetailsService(userService);
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
                logger.warn(authException.getMessage());
                ResponseUtils.printJson(response, ResponseUtils.build(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value(), authException.getMessage()));
            }).accessDeniedHandler(new AccessDeniedHandler() {
                @Override
                public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                    logger.info(accessDeniedException.getMessage());
                }
            });
        }

    }

    @Configuration
    public static class AdministratorSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        @Qualifier("administratorServiceImpl")
        private UserDetailsService userService;
        @Autowired
        private AuthenticationFailureHandler authenticationFailureHandler;
        @Autowired
        private AuthenticationSuccessHandler authenticationSuccessHandler;
        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Bean("administratorJsonUsernamePasswordAuthenticationFilter")
        public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() throws Exception {
            JsonUsernamePasswordAuthenticationFilter filter = new JsonUsernamePasswordAuthenticationFilter();
            filter.setAuthenticationManager(authenticationManagerBean());
            filter.setFilterProcessesUrl("/admin/login");
            filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
            filter.setAuthenticationFailureHandler(authenticationFailureHandler);
            return filter;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            http.addFilterAt(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
            http.csrf().disable().
                    antMatcher("/admin/**")
                    .formLogin().and()
                    .authorizeRequests().anyRequest().permitAll();
            http.userDetailsService(userService);
        }
    }


    @Order(2)
    @Configuration
    public static class CommonSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        private JwtAuthenticationFilter jwtAuthenticationFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            http.csrf().disable().
                    antMatcher("/**").authorizeRequests().anyRequest().permitAll();
            http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
                logger.warn(authException.getMessage());
                ResponseUtils.printJson(response, ResponseUtils.build(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value(), authException.getMessage()));
            }).accessDeniedHandler(new AccessDeniedHandler() {
                @Override
                public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                    logger.info(accessDeniedException.getMessage());
                }
            });
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }
}
