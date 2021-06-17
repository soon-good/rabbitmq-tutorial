package io.study.rabbitmq.tutorial_producer.config.models;

import io.study.rabbitmq.tutorial_producer.producer.PubSubsProducer1;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Publisher, Subscriber 패턴은 브로드캐스팅의 형태와 유사한 형태
// 가장 보편적인 브로드캐스팅 방식의 익스체인지는 Fanout 익스체인지이다.
@Profile({"publisher-subscriber-test1"})
@Configuration
public class PubSubsConfig {

    public static final String EXCHANGE_NAME_FANOUT_TUT1 = "tut.fanout";

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange(EXCHANGE_NAME_FANOUT_TUT1);
    }

    @Bean
    public Binding binding(Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

}
