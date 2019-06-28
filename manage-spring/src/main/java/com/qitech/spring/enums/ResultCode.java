package com.qitech.spring.enums;

/**
 * @program: micro-parent
 * @description: 返回结果码
 * @author: xin.bj
 * @create: 2018-09-13 14:21
 **/
public enum ResultCode {

    /**
     * 参数不正确
     */
    PARAM_IS_INVALID("00001", "参数不正确"),

    /**
     * 数据不存在
     */
    RESULT_DATA_NONE("00002", "数据不存在"),

    /**
     * 数据已存在
     */
    DATA_ALREADY_EXISTED("00003", "数据已存在"),

    /**
     * 系统错误
     */
    SYSTEM_INNER_ERROR("00004", "系统错误"),
    /**
     * 未知错误
     */
    UNKNOW_ERROR("00004", "系统错误"),

    /**
     * 用户名密码错误
     */
    USERNAME_PWD_ERROR("00005", "用户名密码错误"),
    ;

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
