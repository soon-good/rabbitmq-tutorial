package io.study.rabbitmq.tutorial_consumer.tacos.messaging;

import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessagingService{

//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate){
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    public void sendOrder(Order order){
//        MessageConverter converter = rabbitTemplate.getMessageConverter();
//        MessageProperties props = new MessageProperties();
//        Message message = converter.toMessage(order, props);
//        rabbitTemplate.send("tacocloud.order", message);
//    }
}
