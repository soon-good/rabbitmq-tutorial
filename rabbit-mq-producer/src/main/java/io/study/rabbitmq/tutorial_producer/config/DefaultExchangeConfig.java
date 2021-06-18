package io.study.rabbitmq.tutorial_producer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("default-exchange-test1")
@Configuration
public class DefaultExchangeConfig {
    public static final String QUEUE_NAME_SAMPLE1 = "QUEUE_SAMPLE_1";
    public static final String TOPIC_EXCHANGE_NAME1 = "EXCHANGE_SAMPLE_1";
}
