package com.qitech.enums;

/**
 * @author xin.bj
 * @program security-parent
 * @description EquNode设备状态枚举类
 * @create 2019-03-17 21:22
 **/
public enum EquNodeStatusEnum {

    /**
     * 正常
     */
    ONLINE("1", "正常"),

    /**
     * 告警
     */
    ALARM("2", "告警"),

    /**
     * 离线
     */
    OFFLINE("3", "离线"),

    ;

    /**
     * 状态码
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    EquNodeStatusEnum(String code, String desc) {
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
