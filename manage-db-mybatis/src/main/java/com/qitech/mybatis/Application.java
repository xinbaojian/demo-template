package com.qitech.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 将项目中对应的mapper类的路径加进来就可以了
 *
 * @author xin.bj
 */
@SpringBootApplication
@MapperScan("com.qitech.mybatis.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
