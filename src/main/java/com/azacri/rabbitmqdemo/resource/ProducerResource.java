package com.azacri.rabbitmqdemo.resource;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;


    @GetMapping(value="/{message}")
    public String  publish(@PathVariable("message") final String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);

        return "Publishted successfully";
    }

}