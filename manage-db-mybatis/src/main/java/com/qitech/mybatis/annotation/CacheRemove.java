package com.qitech.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @author xin.bj
 * @program security-parent
 * @description 清除Cache注解
 * @date 2019-06-05 18:01
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheRemove {


    /**
     * 需要清除的大类 例如 autocms 所有缓存
     * @return
     */
    String value() default "";

    /**
     * 需要清除的具体的额类型
     */
    String[] keys() default "";
}
