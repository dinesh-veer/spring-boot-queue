package com.dinesh.springbootapacheactivemq.controller;

import com.dinesh.springbootapacheactivemq.model.OrderMessage;
import com.dinesh.springbootapacheactivemq.producer.ActiveMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ActiveMQProducer activeMQProducer;

    @GetMapping
    public String sendMessage(@RequestParam String message){
        activeMQProducer.sendMessage(message);
        return message;
    }

    @PostMapping("/json")
    public String sendJsonMessage(@RequestBody OrderMessage order){
        activeMQProducer.sendJsonMessage(order);
        return "Message sent : " + order;

    }
}
