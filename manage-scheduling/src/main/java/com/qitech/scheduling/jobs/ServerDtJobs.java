package com.qitech.scheduling.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xin.bj
 * @program security-parent
 * @description
 * @create 2019-04-14 17:25
 **/
@Slf4j
@Component
public class ServerDtJobs {

    private final static long ONE_DAY = 1000 * 60 * 60 * 24;

    @Value("${serverdt.delete}")
    private Integer limitSeconds;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired

    @Scheduled(fixedDelay = ONE_DAY)
    public void deleteData() {
        //do something
    }
}
