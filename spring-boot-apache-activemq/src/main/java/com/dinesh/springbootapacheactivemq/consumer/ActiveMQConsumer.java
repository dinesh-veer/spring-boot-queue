package com.dinesh.springbootapacheactivemq.consumer;

import com.dinesh.springbootapacheactivemq.model.OrderMessage;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class ActiveMQConsumer {

    private final ObjectMapper objectMapper;

    @JmsListener(destination = "demo-activemq")
    public void receiveMessage(String message){
        System.out.println("Received message: " + message + " | " + Thread.currentThread().getName());
    }


    @JmsListener(destination = "demo.activemqjson")
    public void receiveJson(TextMessage message) {
        try {
            String json = message.getText();

            OrderMessage order =
                    objectMapper.readValue(json, OrderMessage.class);

            System.out.println("Received Object: " + order);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
