package com.seal.service;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: yangkai
 * @Date: 2022/3/31 14:48
 */
//因为要跟MQ绑定，所以不再使用@Service
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider{

    @Resource
    private MessageChannel output; //消息发送管道
    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial: "+serial);
        return null;
    }
}
