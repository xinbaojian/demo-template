package com.qitech.enums;

/**
 * @author xin.bj
 * @program security-parent
 * @description 接口调用类型枚举类
 * @create 2019-03-21 10:13
 **/
public enum InterfaceCallTypeEnum {
    /**
     * GET 方法
     */
    GET("GET", "GET"),

    /**
     * POST 方法
     */
    POST("POST", "POST");

    private String code;

    private String desc;


    InterfaceCallTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
