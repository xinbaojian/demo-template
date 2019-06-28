package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description: 数据已存在异常
 * @author: xin.bj
 * @create: 2018-09-13 14:12
 **/
public class DataConflictException extends BusinessException {

    public DataConflictException() {
        super();
    }

    public DataConflictException(Object data) {
        super();
        super.data = data;
    }

    public DataConflictException(ResultCode resultCode) {
        super(resultCode);
    }

    public DataConflictException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public DataConflictException(String msg) {
        super(msg);
    }

    public DataConflictException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
