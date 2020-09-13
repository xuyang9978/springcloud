package run.xuyang.springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import run.xuyang.springcloud.service.IMessageProvider;

import java.util.UUID;

/**
 * @author XuYang
 * @date 2020/9/7 11:44
 */
@EnableBinding(Source.class)    // 定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    private final MessageChannel output;

    public IMessageProviderImpl(MessageChannel output) {
        this.output = output;
    }

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("******serial: " + serial);
        return null;
    }
}
