package com.qitech.stream.receiver;

import com.qitech.stream.client.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author xin.bj
 * @program security-manage-parent
 * @description 创建消费者
 * @create 2019-07-02 10:21
 **/
@Slf4j
@Component
@EnableBinding(value = {StreamClient.class})
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    public void receive(String message) {
        log.info("StreamReceiver {}", message);
    }
}
