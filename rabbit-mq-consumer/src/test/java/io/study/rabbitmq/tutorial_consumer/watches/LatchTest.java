package io.study.rabbitmq.tutorial_consumer.watches;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LatchTest {

    @Test
    void testLatch1() throws Exception{
        CountDownLatch latch = new CountDownLatch(1);

        latch.await(1000, TimeUnit.MILLISECONDS);
        System.out.println("abc");
        latch.countDown();
        System.out.println(latch);

        System.out.println("def");
    }
}
