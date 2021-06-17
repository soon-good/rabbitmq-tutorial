package io.study.rabbitmq.tutorial_producer.listener;

import com.rabbitmq.client.Channel;
import io.study.rabbitmq.tutorial_producer.config.RabbitConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
@RabbitListener(queues = RabbitConfiguration.QUEUE_NAME_SAMPLE1)
public class DefaultListener {

    @RabbitHandler
    public void receiveMessage(LinkedHashMap message, Channel channel,
                               @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        try {
            System.out.println("[result ] >>> " + String.valueOf(message));
            channel.basicAck(tag, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @RabbitListener(queues = {RabbitConfiguration.QUEUE_NAME_SAMPLE1}, concurrency = "3-5")
//    public void consume(Message message){
//        System.out.println("[메시지 (consume)] :: " + message.getBody().toString());
//    }
//
//    @RabbitListener(
//            concurrency = "3-5",
//            bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = RabbitConfiguration.QUEUE_NAME_SAMPLE1),
//                            exchange = @Exchange(name = "amqp.direct")
//                    )
//            }
//    )
//    public void receive(Message message){
//        System.out.println("[메시지 (receive)] :: " + message.getBody().toString());
//    }
}
