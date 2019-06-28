package com.qitech.utils;

import java.util.UUID;

/**
 * @program: micro-parent
 * @description: UUID辅助类
 * @author: xin.bj
 * @create: 2018-08-31 17:10
 **/
public class UUIDUtils {

    private UUIDUtils() {
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
