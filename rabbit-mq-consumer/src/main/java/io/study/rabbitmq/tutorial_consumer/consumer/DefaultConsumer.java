package io.study.rabbitmq.tutorial_consumer.consumer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("default-exchange-test1")
@Service
public class DefaultConsumer {

//    @RabbitListener(queues = {QUEUE_NAME_SAMPLE1}, concurrency = "3-5")
//    public void consume(Message message){
//        System.out.println("[메시지 (consume)] :: " + String.valueOf(message));
//    }

//    @RabbitListener(
//            concurrency = "3-5",
//            bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = QUEUE_NAME_SAMPLE1),
//                            exchange = @Exchange(name = "amq.direct")
//                    )
//            }
//    )
//    public void receive(Message message){
//        System.out.println("[메시지 (receive)] :: " + String.valueOf(message));
//    }
}
