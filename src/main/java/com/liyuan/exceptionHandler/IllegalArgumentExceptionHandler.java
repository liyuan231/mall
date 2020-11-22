package com.liyuan.exceptionHandler;

import com.liyuan.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class IllegalArgumentExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(IllegalArgumentException.class)
    public Object illegalArgumentException(HttpServletRequest request, IllegalArgumentException e) {
        logger.error("[" + request.getRemoteUser() + "]" + e.getMessage());
        return ResponseUtils.build(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
