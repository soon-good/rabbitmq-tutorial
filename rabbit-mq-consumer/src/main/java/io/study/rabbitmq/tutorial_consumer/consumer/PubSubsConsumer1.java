package io.study.rabbitmq.tutorial_consumer.consumer;

import io.study.rabbitmq.tutorial_consumer.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Profile("publisher-subscriber-test1")
@Service
public class PubSubsConsumer1 {

    @RabbitListener(queues = {RabbitConfig.SPRING_AMQP_QUEUE})
    public void receive1(final Message in) throws InterruptedException {
//        receive(in, 1);
        System.out.println("in >>> " + String.valueOf(in));
        System.out.println("in.getBody() >>> " + in.getBody().toString());
    }

    public void receive(String in, int receiver) throws InterruptedException{
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance " + receiver + " [x] Received '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + receiver + " [x] Done in " + watch.getTotalTimeSeconds() + "s");
    }

    private void doWork(String in) throws InterruptedException {
        for(char ch : in.toCharArray()){
            if(ch == '.'){
                Thread.sleep(1000);
            }
        }
    }
}
