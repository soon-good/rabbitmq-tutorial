package io.study.rabbitmq.tutorial_consumer.config.models;

import io.study.rabbitmq.tutorial_consumer.consumer.PubSubsConsumer1;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Publishsr, Subscriber 패턴은 브로드캐스팅의 형태와 유사한 형태
// 가장 보편적인 브로드캐스팅 방식의 익스체인지는 Fanout 익스체인지이다.
@Profile({"publisher-subscriber-test1"})
@Configuration
public class PubSubsConfig {

    public static final String EXCHANGE_NAME_FANOUT_TUT1 = "tut.fanout";

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange(EXCHANGE_NAME_FANOUT_TUT1);
    }

    @Profile("publisher-subscriber-test1")
    private static class ConsumerConfig{

        @Bean
        public Queue autoDeleteQueue1(){
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2(){
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanoutExchange, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(fanoutExchange);
        }

        @Bean
        public Binding binding2(FanoutExchange fanoutExchange, Queue autoDeleteQueue2){
            return BindingBuilder.bind(autoDeleteQueue2).to(fanoutExchange);
        }

        @Profile("publisher-subscriber-test1")
        @Bean
        public PubSubsConsumer1 receiver(){
            return new PubSubsConsumer1();
        }
    }
}
