package com.qitech.enums;

/**
 * @author xin.bj
 * @program security-parent
 * @description 接口调用状态枚举
 * @create 2019-03-21 10:16
 **/
public enum InterfaceStatusEnum {
    /**
     * 成功
     */
    SUCCESS("1", "成功"),
    /**
     * 失败
     */
    FAIL("0", "失败"),
    ;

    private String code;

    private String desc;

    InterfaceStatusEnum(String code, String desc) {
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
    }
}
