package com.qitech.mybatis.exception;

/**
 * @program: security-parent
 * @description: Example参数异常
 * @author: xin.bj
 * @create: 2018-10-27 09:49
 **/
public class InvalidConditionException extends RuntimeException {

    public InvalidConditionException(String message) {
        super(message);
    }
}
