package com.dinesh.springbootrabbitmq.consumer;

import com.dinesh.springbootrabbitmq.model.OrderMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "demo-rabbitmq")
    public void receiveMessage(String message) {
        System.out.println("Receive Message: " + message);
    }

    @RabbitListener(queues = "demo-rabbitmqjson")
    public void receiveMessageJson(String jsonMessage) throws JsonProcessingException {

        OrderMessage order =
                objectMapper.readValue(jsonMessage, OrderMessage.class);

        System.out.println("Received: " + order);
    }

}
