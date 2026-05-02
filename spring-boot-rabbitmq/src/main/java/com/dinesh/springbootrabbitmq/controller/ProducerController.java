package com.dinesh.springbootrabbitmq.controller;

import com.dinesh.springbootrabbitmq.model.OrderMessage;
import com.dinesh.springbootrabbitmq.producer.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final RabbitMQProducer rabbitMQProducer;

    @GetMapping
    public String index(@RequestParam String message) {
        rabbitMQProducer.sendMessage(message);
        return message;
    }

    @PostMapping
    public String sendOrderMessage(@RequestBody OrderMessage message) {
        rabbitMQProducer.sendJsonMessage(message);
        return "Message sent : " + message;
    }
}
