package com.dinesh.springbootrabbitmq.producer;

import com.dinesh.springbootrabbitmq.model.OrderMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(String message) {
        System.out.println("Send Message: " + message);
        rabbitTemplate.convertAndSend("demo-rabbitmq", message);
    }

    public void sendJsonMessage(OrderMessage order) {
        try {
            String json = objectMapper.writeValueAsString(order);

            System.out.println("Producing: " + json);

            rabbitTemplate.convertAndSend("","demo-rabbitmqjson",json);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
