package com.qitech.admin;

import com.qitech.admin.config.DruidConfig;
import com.qitech.admin.config.SwaggerConfig;
import com.qitech.spring.redisconfig.RedisConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @program: micro-parent
 * @description: 全局配置类
 * @author: xin.bj
 * @create: 2018-08-25 13:21
 **/
@Configuration
@EnableAutoConfiguration
@Import({DruidConfig.class, SwaggerConfig.class, RedisConfig.class})
public class AppConfig {
}
