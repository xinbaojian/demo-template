package com.qitech.websocket.endpoint;

import com.qitech.websocket.SpringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author xin.bj
 * @program security-parent
 * @description WebSocket测试
 * @create 2019-02-27 10:46
 * topic 指 向哪个频道主题里发消息
 * id 指 这个消息是谁的(用户ID)
 **/
@Component
@ServerEndpoint(value = "/channel/{topic}/{id}")
public class SocketChannelTopic {

    /**
     * 因为@ServerEndpoint不支持注入，所以使用SpringUtils获取IOC实例
     */
    private StringRedisTemplate redisTampate = SpringUtils.getBean(StringRedisTemplate.class);

    private RedisMessageListenerContainer redisMessageListenerContainer = SpringUtils.getBean(RedisMessageListenerContainer.class);

    /**
     * 存放该服务器该ws的所有连接。用处：比如向所有连接该ws的用户发送通知消息。
     */
    private static CopyOnWriteArraySet<SocketChannelTopic> sessions = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam("topic") String topic) {
        System.out.println("java websocket:打开连接");
        this.session = session;
        sessions.add(this);
        SubscribeListener subscribeListener = new SubscribeListener();
        subscribeListener.setSession(session);
        subscribeListener.setStringRedisTemplate(redisTampate);
        //设置订阅topic
        redisMessageListenerContainer.addMessageListener(subscribeListener, new ChannelTopic(topic));
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("java websocket:关闭连接");
        sessions.remove(this);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("topic") String topic, @PathParam("id") String id) {
        message = id + "：" + message;
        System.out.println("java websocket 收到消息==" + message);
        PublishService publishService = SpringUtils.getBean(PublishService.class);
        publishService.publish(topic, message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("java websocket 出现错误");
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
