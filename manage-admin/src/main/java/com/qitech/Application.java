package com.qitech;

import com.qitech.admin.AppConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * //MapperScan 将项目中对应的mapper类的路径加进来就可以了
 * @author xin.bj
 */
@EnableCaching
@EnableDiscoveryClient
@Import({AppConfig.class})
@SpringBootApplication(scanBasePackages = "com.qitech")
@MapperScan("com.qitech.mybatis.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
