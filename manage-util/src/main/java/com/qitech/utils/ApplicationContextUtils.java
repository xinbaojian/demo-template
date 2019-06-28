package com.qitech.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;

/**
 * @author xin.bj
 * @program security-parent
 * @description ApplicationContextUtils
 * @create 2019-03-02 01:00
 **/
@Configuration
@SuppressWarnings("unchecked")
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 发布事件
     *
     * @param event event
     */
    public static void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    public static Object getBean(Class clazz){
        return applicationContext.getBean(clazz);
    }

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtils.applicationContext = applicationContext;
    }
}
