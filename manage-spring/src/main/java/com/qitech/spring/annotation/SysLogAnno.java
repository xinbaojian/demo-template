package com.qitech.spring.annotation;

import java.lang.annotation.*;

/**
 * @author xin.bj
 * @program security-parent
 * @description 操作日志自定义注解
 * @date 2019-06-01 15:01
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLogAnno {

    /**
     * 日志title
     */
    String[] title() default "";
}
