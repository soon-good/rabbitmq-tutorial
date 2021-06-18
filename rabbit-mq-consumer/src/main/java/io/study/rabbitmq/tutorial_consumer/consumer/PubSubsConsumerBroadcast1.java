package io.study.rabbitmq.tutorial_consumer.consumer;

import io.study.rabbitmq.tutorial_consumer.config.models.PubSubsBroadCastConfig1;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("publisher-subscriber-broadcast1")
@Service
public class PubSubsConsumerBroadcast1 {

    @RabbitListener(queues = PubSubsBroadCastConfig1.QUEUE_PUBLISHER_SUBSCRIBER1)
    public void receive1(final Message in) throws InterruptedException {
        System.out.println("[1번 큐] 메시지(Message) >>> " + String.valueOf(in));
    }

    @RabbitListener(queues = PubSubsBroadCastConfig1.QUEUE_PUBLISHER_SUBSCRIBER2)
    public void receive2(final Message in) throws InterruptedException {
        System.out.println("[2번 큐] 메시지(Message) >>> " + String.valueOf(in));
    }
}
