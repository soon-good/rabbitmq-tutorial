package io.study.rabbitmq.tutorial_producer.producer;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class PubSubsProducer1 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    AtomicInteger dots = new AtomicInteger(0);

    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 2000, initialDelay = 500)
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
        System.out.println(" [x] Sent '" + message + "'");
    }
}
