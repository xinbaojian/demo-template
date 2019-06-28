package com.qitech.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务子模块
 * @author xinbj
 */
@EnableScheduling
@EnableDiscoveryClient
@Import({AppConfig.class})
@SpringBootApplication(scanBasePackages = "com.qitech")
public class SchedulingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulingApplication.class, args);
    }
}
