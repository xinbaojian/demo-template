package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description: 无效参数异常
 * @author: xin.bj
 * @create: 2018-09-13 14:11
 **/
public class ParameterInvalidException extends BusinessException {

    public ParameterInvalidException() {
        super();
    }

    public ParameterInvalidException(Object data) {
        super();
        super.data = data;
    }

    public ParameterInvalidException(ResultCode resultCode) {
        super(resultCode);
    }

    public ParameterInvalidException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public ParameterInvalidException(String msg) {
        super(msg);
    }

    public ParameterInvalidException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
