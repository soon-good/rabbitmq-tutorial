package io.study.rabbitmq.tutorial_producer.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Profile("publisher-subscriber-broadcast1")
@Service
public class PubSubsProducerBroadcast1 {
    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    @Autowired
    public PubSubsProducerBroadcast1(RabbitTemplate rabbitTemplate, FanoutExchange fanoutExchange){
        this.rabbitTemplate = rabbitTemplate;
        this.fanoutExchange = fanoutExchange;
    }

    @Scheduled(fixedDelay = 100, initialDelay = 500)
    public void send(){
        StringBuilder builder = new StringBuilder("Hello");

        if(dots.getAndIncrement() == 3){
            dots.set(1);
        }

        for(int i=0; i<dots.get(); i++){
            builder.append(".");
        }

        builder.append(count.incrementAndGet());
        String message = builder.toString();
        // Publisher, Subscriber 모델은 브로드캐스팅 모델이므로 라우팅키가 무의미하다. 따라서 routingKey 를 공백문자("")로 지정.
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
        System.out.println(" 프로듀서가 메시지를 보냅니다. ['" + message + "']");
    }
}
