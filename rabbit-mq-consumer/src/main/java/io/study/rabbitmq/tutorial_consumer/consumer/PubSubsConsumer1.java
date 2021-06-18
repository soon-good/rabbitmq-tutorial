package io.study.rabbitmq.tutorial_consumer.consumer;

import io.study.rabbitmq.tutorial_consumer.config.models.PubSubsToSingleUserConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("publisher-subscriber-test1")
@Service
public class PubSubsConsumer1 {

    @RabbitListener(queues = {PubSubsToSingleUserConfig.QUEUE_PUBLISHER_SUBSCRIBER1})
    public void receive1(final Message in) throws InterruptedException {
        System.out.println("in >>> " + String.valueOf(in));
        System.out.println("in.getBody() >>> " + in.getBody().toString());
    }
}
