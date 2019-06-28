package com.qitech.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka-server
 * @author xin.bj
 */
@EnableEurekaServer
@SpringBootApplication
public class MicroEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroEurekaServerApplication.class, args);
    }
}
