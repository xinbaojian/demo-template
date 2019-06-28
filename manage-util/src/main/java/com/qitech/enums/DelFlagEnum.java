package com.qitech.enums;

/**
 * @author xin.bj
 * @program security-parent
 * @description 删除标识枚举
 * @date 2019-05-10 16:20
 **/
public enum DelFlagEnum {
    /**
     * 正常
     */
    TRUE("0", "正常"),
    /**
     * 删除
     */
    FALSE("1", "删除"),
    ;

    private String code;

    private String desc;

    DelFlagEnum(String code, String desc) {
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
