package com.qitech.utils;

import com.qitech.enums.ResponseErrorEnum;

/**
 * @program: micro-parent
 * @description: 接口返回统一响应结构体
 * @author: xin.bj
 * @create: 2018-08-25 10:02
 **/
public class ResponseResult<T> {

    private static ResponseResult ourInstance = new ResponseResult();

    public static ResponseResult getInstance() {
        return ourInstance;
    }

    private ResponseResult() {
    }

    private boolean success;
    private String message;
    private T data;
    /**
     * 不提供直接设置errorCode的接口，只能通过setErrorInfo方法设置错误信息
     */
    private String errorCode;

    private ResponseErrorEnum errorInfo;

    public boolean isSuccess() {
        return success;
    }

    public ResponseResult<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public ResponseResult<T> success() {
        this.success = Boolean.TRUE;
        this.errorCode = null;
        this.errorInfo = null;
        this.message = "";
        this.data = null;
        return this;
    }

    public ResponseResult<T> error(){
        this.success = false;
        this.errorCode = null;
        this.errorInfo = null;
        this.message = "";
        this.data = null;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ResponseResult<T> setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ResponseErrorEnum getErrorInfo() {
        return errorInfo;
    }

    public ResponseResult<T> setErrorInfo(ResponseErrorEnum errorInfo) {
        this.errorInfo = errorInfo;
        return this;
    }
}
