package com.qitech.websocket.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.websocket.Session;
import java.io.IOException;

/**
 * @author xin.bj
 * @program security-parent
 * @description 订阅监听器
 * @create 2019-04-11 17:15
 **/
@Slf4j
public class SubscribeListener implements MessageListener {

    private StringRedisTemplate stringRedisTemplate;

    private Session session;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = new String(message.getBody());
        log.info("{}主题发布: {}", new String(bytes), msg);
        if (null != session && session.isOpen()){
            try {
                session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                log.error("{}主题发布: {} 出错了", new String(bytes), msg);
            }
        }
    }

    public StringRedisTemplate getStringRedisTemplate() {
        return stringRedisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
