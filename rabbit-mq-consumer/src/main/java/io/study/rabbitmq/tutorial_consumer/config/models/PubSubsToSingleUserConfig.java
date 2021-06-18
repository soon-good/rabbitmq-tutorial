package io.study.rabbitmq.tutorial_consumer.config.models;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Publishsr, Subscriber 패턴은 브로드캐스팅의 형태와 유사한 형태
// 가장 보편적인 브로드캐스팅 방식의 익스체인지는 Fanout 익스체인지이다.
@Profile({"publisher-subscriber-test1"})
@Configuration
public class PubSubsToSingleUserConfig {

    public static final String EXCHANGE_FANOUT_TUT = "tut.fanout";
    public static final String QUEUE_PUBLISHER_SUBSCRIBER1 = "publisher-subscriber-1";

    @Bean(name = "readQueue1")
    public Queue queuePublisherSubscriber1(){
        return new Queue(QUEUE_PUBLISHER_SUBSCRIBER1);
    }

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange(EXCHANGE_FANOUT_TUT);
    }

    @Bean(name = "binding1")
    public Binding binding1(@Qualifier("readQueue1") Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
