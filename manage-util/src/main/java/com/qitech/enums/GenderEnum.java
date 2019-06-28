package com.qitech.enums;

/**
 * @program: micro-parent
 * @description: 性别枚举
 * @author: xin.bj
 * @create: 2018-08-25 09:36
 */
public enum GenderEnum {

    /**
     * 男
     */
    MALE((byte) 0, "男"),

    /**
     * 女
     */
    FEMALE((byte) 1, "女"),

    /**
     * 无性别
     */
    ASEXUALITY((byte) 2, "保密");


    GenderEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private byte code;

    private String desc;
}