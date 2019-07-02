package com.qitech.stream.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xin.bj
 * @program security-manage-parent
 * @description  创建消息通道绑定的接口
 * @create 2019-07-02 10:08
 **/
public interface StreamClient {

    /**
     * 输入通道名称
     */
    String INPUT = "myInput";
    /**
     * 输出通道名称
     */
    String OUTPUT = "myOutput";


    /**
     * 定义输入通道
     * 如果直接使用两个注解而没有指定具体的 value 值，则会默认使用方法名作为消息通道的名称
     *
     * @return SubscribableChannel
     */
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    /**
     * 定义输出通道
     * 如果直接使用两个注解而没有指定具体的 value 值，则会默认使用方法名作为消息通道的名称
     *
     * @return MessageChannel
     */
    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
