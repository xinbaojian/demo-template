package com.qitech.spring.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author xin.bj
 */
public class InvalidJwtAuthenticationException extends AuthenticationException {
    public InvalidJwtAuthenticationException(String e) {
        super(e);
    }
}
