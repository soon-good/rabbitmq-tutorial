package io.study.rabbitmq.tutorial_producer.config.models;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("publisher-subscriber-broadcast1")
@Configuration
public class PubSubsBroadCastConfig1 {
    public static final String EXCHANGE_FANOUT_TO_MULTIPLE_QUEUE = "tut.fanout.to.multiple-queue";
    public static final String QUEUE_PUBLISHER_SUBSCRIBER1 = "publisher-subscriber-1";
    public static final String QUEUE_PUBLISHER_SUBSCRIBER2 = "publisher-subscriber-2";
    public static final String BEAN_FANOUT_TO_MULTIPLE_QUEUE = "fanoutToMultipleQueue";

    @Bean(name = "readQueue1")
    public Queue queuePublisherSubscriber1(){
        return new Queue(QUEUE_PUBLISHER_SUBSCRIBER1);
    }

    @Bean(name = "readQueue2")
    public Queue queuePublisherSubscriber2(){
        return new Queue(QUEUE_PUBLISHER_SUBSCRIBER2);
    }

    @Bean(name = BEAN_FANOUT_TO_MULTIPLE_QUEUE)
    public FanoutExchange fanout(){
        return new FanoutExchange(EXCHANGE_FANOUT_TO_MULTIPLE_QUEUE);
    }

    @Bean(name = "binding1")
    public Binding binding1(@Qualifier("readQueue1") Queue queue,
                            @Qualifier(BEAN_FANOUT_TO_MULTIPLE_QUEUE) FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean(name = "binding2")
    public Binding binding2(@Qualifier("readQueue2") Queue queue,
                            @Qualifier(BEAN_FANOUT_TO_MULTIPLE_QUEUE) FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
