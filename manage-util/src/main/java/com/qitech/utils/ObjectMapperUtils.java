package com.qitech.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: security-parent
 * @description: ObjectMapper辅助类
 * @author: xin.bj
 * @create: 2018-10-16 15:10
 **/
@Slf4j
public class ObjectMapperUtils {

    private ObjectMapperUtils() {
    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getInstance() {
        //设置值为空的属性转换json后不显示
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    /**
     * 对象集合转换
     *
     * @param list
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> convertValue(List<Object> list, Class<T> clazz) {
        if (list == null || list.size() == 0){
            return new ArrayList<>();
        }
        return list.stream().map(t -> getInstance().convertValue(t, clazz)).collect(Collectors.toList());
    }

    /**
     * 对象转换
     *
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T convertValue(Object value, Class<T> clazz) {
        return getInstance().convertValue(value, clazz);
    }

    public static String toJson(Object object) {
        try {
            return getInstance().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("解析json出错了", e);
        }
        return StringUtil.EMPTY;
    }
}
