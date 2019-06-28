package com.qitech.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

/**
 * @program: micro-parent
 * @description: Gson辅助类
 * @author: xin.bj
 * @create: 2018-08-25 10:09
 **/
public class GsonUtils {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private GsonUtils() {
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static JsonElement toJsonElement(Object obj) {
        return gson.toJsonTree(obj);
    }

    public static String getAsString(Object json) {
        if (json == null){
            return null;
        }
        return toJsonElement(json).getAsString();
    }
}
