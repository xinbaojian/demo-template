package com.qitech.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: micro-parent
 * @description: 响应错误类型枚举
 * @author: xin.bj
 * @create: 2018-08-25 10:12
 **/
public enum ResponseErrorEnum {

    /**
     * 请求参数不合法
     */
    ILLEGAL_PARAMS("ILLEGAL_PARAMS", "请求参数不合法!"),
    /**
     * 接口内部异常
     */
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", "接口内部异常!");

    private String code;

    private String message;

    ResponseErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 序列化enum
     *
     * @return
     */
    @JsonValue
    private Map<String, Object> serialize() {
        Map<String, Object> valueMap = new HashMap<>(2);
        valueMap.put("code", this.code);
        valueMap.put("message", this.message);
        return valueMap;
    }
}
