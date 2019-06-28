package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description:
 * @author: xin.bj
 * @create: 2018-09-21 17:24
 **/
public class InvalidTokenException extends BusinessException {

    public InvalidTokenException() {
        super();
    }

    public InvalidTokenException(Object data) {
        super();
        super.data = data;
    }

    public InvalidTokenException(ResultCode resultCode) {
        super(resultCode);
    }

    public InvalidTokenException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public InvalidTokenException(String msg) {
        super(msg);
    }

    public InvalidTokenException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
