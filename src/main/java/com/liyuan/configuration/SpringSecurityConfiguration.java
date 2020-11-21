package com.liyuan.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        jsr250Enabled = true,
        securedEnabled = true
)
public class SpringSecurityConfiguration {
    @Bean

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Primary
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Configuration
    @Order(1)
    public static class ClientSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        @Qualifier("userServiceImpl")
        private UserDetailsService userService;
        //    @Autowired
//    private AuthenticationFailureHandler authenticationFailureHandler;
        @Autowired
        private AuthenticationSuccessHandler authenticationSuccessHandler;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().
                    antMatcher("/client/**").formLogin().loginProcessingUrl("/client/login")
                    .successHandler(authenticationSuccessHandler)
                    .and().authorizeRequests().anyRequest().permitAll();
            http.userDetailsService(userService);
        }
    }

    @Configuration
    public static class AdministratorSpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        @Qualifier("administratorServiceImpl")
        private UserDetailsService userService;
        //    @Autowired
//    private AuthenticationFailureHandler authenticationFailureHandler;
        @Autowired
        private AuthenticationSuccessHandler authenticationSuccessHandler;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().
                    antMatcher("/admin/**").
                    formLogin().loginProcessingUrl("/admin/login")
                    .successHandler(authenticationSuccessHandler)
                    .and().authorizeRequests().anyRequest().permitAll();
            http.userDetailsService(userService);
        }
    }


}
