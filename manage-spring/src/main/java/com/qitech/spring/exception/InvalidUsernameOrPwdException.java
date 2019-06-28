package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description:
 * @author: xin.bj
 * @create: 2018-09-21 17:24
 **/
public class InvalidUsernameOrPwdException extends BusinessException {

    public InvalidUsernameOrPwdException() {
        super();
    }

    public InvalidUsernameOrPwdException(Object data) {
        super();
        super.data = data;
    }

    public InvalidUsernameOrPwdException(ResultCode resultCode) {
        super(resultCode);
    }

    public InvalidUsernameOrPwdException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public InvalidUsernameOrPwdException(String msg) {
        super(msg);
    }

    public InvalidUsernameOrPwdException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
