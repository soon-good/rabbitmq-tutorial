package io.study.rabbitmq.tutorial_consumer.listener;

//@Profile("default-exchange-test1")
//@Component
//@RabbitListener(queues = RabbitConfiguration.QUEUE_NAME_SAMPLE1)
public class DefaultListener {

//    @RabbitHandler
//    public void receiveMessage(LinkedHashMap message, Channel channel,
//                               @Header(AmqpHeaders.DELIVERY_TAG) long tag){
//        try {
//            System.out.println("[result ] >>> " + String.valueOf(message));
//            channel.basicAck(tag, false);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    @RabbitListener(queues = {RabbitConfiguration.QUEUE_NAME_SAMPLE1}, concurrency = "3-5")
//    public void consume(Message message){
//        System.out.println("[메시지 (consume)] :: " + message.getBody().toString());
//    }
//
//    @RabbitListener(
//            concurrency = "3-5",
//            bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = RabbitConfiguration.QUEUE_NAME_SAMPLE1),
//                            exchange = @Exchange(name = "amqp.direct")
//                    )
//            }
//    )
//    public void receive(Message message){
//        System.out.println("[메시지 (receive)] :: " + message.getBody().toString());
//    }
}
