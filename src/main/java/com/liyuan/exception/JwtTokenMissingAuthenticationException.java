package com.liyuan.exception;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingAuthenticationException extends AuthenticationException {

    public JwtTokenMissingAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtTokenMissingAuthenticationException(String msg) {
        super(msg);
    }
}
