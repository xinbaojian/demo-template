package com.qitech.websocket.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xin.bj
 * @program security-parent
 * @description 发布Service
 * @create 2019-04-11 17:13
 **/
@Component
public class PublishService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发布方法
     * @param channel 消息发布订阅，主题
     * @param message 消息信息
     */
    public void publish(String channel, Object message) {
        stringRedisTemplate.convertAndSend(channel, message);
    }
}
