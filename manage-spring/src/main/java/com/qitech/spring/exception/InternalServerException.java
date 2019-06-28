package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description: 系统内部错误异常
 * @author: xin.bj
 * @create: 2018-09-13 14:20
 **/
public class InternalServerException extends BusinessException {

    public InternalServerException() {
        super();
    }

    public InternalServerException(Object data) {
        super();
        super.data = data;
    }

    public InternalServerException(ResultCode resultCode) {
        super(resultCode);
    }

    public InternalServerException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public InternalServerException(String msg) {
        super(msg);
    }

    public InternalServerException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
