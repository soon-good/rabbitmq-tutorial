package io.study.rabbitmq.tutorial_producer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile({"publisher-subscriber-test1", "publisher-subscriber-broadcast1"})
@Configuration
@EnableScheduling
public class PublisherConfig {
}
