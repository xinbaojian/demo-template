package com.qitech.spring.exception;

import com.qitech.spring.enums.ExceptionEnum;
import com.qitech.spring.enums.ResultCode;
import com.qitech.utils.StringUtil;

/**
 * @program: micro-parent
 * @description: 业务类异常
 * @author: xin.bj
 * @create: 2018-09-13 14:17
 **/
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 194906846739586856L;

    protected String code;

    protected String message;

    protected ResultCode resultCode;

    protected Object data;

    public BusinessException() {
        ExceptionEnum exceptionEnum = ExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            resultCode = exceptionEnum.getResultCode();
            code = exceptionEnum.getResultCode().getCode();
            message = exceptionEnum.getResultCode().getMessage();
        }

    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        format = StringUtil.replace(format, "{}", "%s");
        this.message = String.format(format, objects);
    }

    public BusinessException(ResultCode resultCode, Object data) {
        this(resultCode);
        this.data = data;
    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}
