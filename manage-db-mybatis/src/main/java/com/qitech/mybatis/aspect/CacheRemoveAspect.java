package com.qitech.mybatis.aspect;

import com.qitech.mybatis.annotation.CacheRemove;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author xin.bj
 * @program security-parent
 * @description 清除缓存切面类
 * @date 2019-06-06 11:02
 **/
@Slf4j
@Aspect
@Component
public class CacheRemoveAspect {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public CacheRemoveAspect(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 截获标有@CacheRemove的方法
     */
    @Pointcut("@annotation(com.qitech.mybatis.annotation.CacheRemove)")
    private void pointcut() {
    }

    /**
     * 功能描述: 切面在截获方法返回值之后
     *
     * @return void
     * @throws
     * @author fuyuchao
     * @date 2018/9/14 16:55
     * @params [joinPoint]
     */
    @AfterReturning(value = "pointcut()")
    private void process(JoinPoint joinPoint) {
        //获取被代理的类
        Object target = joinPoint.getTarget();
        //获取切入方法的数据
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入方法
        Method method = signature.getMethod();
        //获得注解
        CacheRemove cacheRemove = method.getAnnotation(CacheRemove.class);

        if (cacheRemove != null) {
            String value = cacheRemove.value();
            if (!"".equals(value)) {
                //缓存的项目所有redis业务部缓存
                cleanRedisCache("*" + value + "*");
            }
            //需要移除的正则key
            String[] keys = cacheRemove.keys();
            for (String key : keys) {
                //指定清除的key的缓存
                if (!"".equals(key)) {
                    cleanRedisCache("*" + key + "*");
                }
            }
        }
    }

    private void cleanRedisCache(String key) {
        if (key != null) {
            Set<String> stringSet = redisTemplate.keys(key);
            //删除缓存
            if (stringSet != null) {
                redisTemplate.delete(stringSet);
                log.info("清除 " + key + " 缓存");
            }
        }
    }
}
