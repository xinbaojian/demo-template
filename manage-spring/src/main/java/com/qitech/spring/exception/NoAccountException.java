package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description: 找不到用户自定义异常
 * @author: xin.bj
 * @create: 2018-09-13 13:59
 **/
public class NoAccountException extends BusinessException {

    public NoAccountException() {
        super();
    }

    public NoAccountException(Object data) {
        super();
        super.data = data;
    }

    public NoAccountException(ResultCode resultCode) {
        super(resultCode);
    }

    public NoAccountException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public NoAccountException(String msg) {
        super(msg);
    }

    public NoAccountException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
