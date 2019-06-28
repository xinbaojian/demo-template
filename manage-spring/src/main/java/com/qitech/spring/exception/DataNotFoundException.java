package com.qitech.spring.exception;

import com.qitech.spring.enums.ResultCode;

/**
 * @program: micro-parent
 * @description: 数据未找到异常
 * @author: xin.bj
 * @create: 2018-09-13 14:12
 **/
public class DataNotFoundException extends BusinessException {

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public DataNotFoundException(ResultCode resultCode) {
        super(resultCode);
    }

    public DataNotFoundException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }
}
