package io.study.rabbitmq.tutorial_consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("default-exchange-test1")
@Configuration
public class RabbitConfiguration {
    public static final String QUEUE_NAME_SAMPLE1 = "QUEUE_SAMPLE_1";
    public static final String TOPIC_EXCHANGE_NAME1 = "EXCHANGE_SAMPLE_1";

    @Bean
    Queue defaultQueue(){
        return new Queue(QUEUE_NAME_SAMPLE1, false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(TOPIC_EXCHANGE_NAME1);
    }

    @Bean
    Binding bindingDefault(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("direct.#");
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
}
