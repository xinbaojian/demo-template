package com.qitech.stream;

import com.qitech.stream.client.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息队列
 *
 * @author xinbj
 */
@RestController
@SpringBootApplication
public class StreamApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamApplication.class, args);
    }

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/send")
    public void send() {
        streamClient.output().send(MessageBuilder.withPayload("Hello World...").build());
    }
}
