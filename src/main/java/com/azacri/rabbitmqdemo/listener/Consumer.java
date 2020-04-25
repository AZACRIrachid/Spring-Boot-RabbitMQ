package com.azacri.rabbitmqdemo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {


    
    private static final String MY_QUEUE_NAME = "myQueue";

    @RabbitListener(queues = MY_QUEUE_NAME)
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }

}