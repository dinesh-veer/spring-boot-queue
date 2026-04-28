package com.dinesh.springbootapacheactivemq.producer;

import com.dinesh.springbootapacheactivemq.model.OrderMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class ActiveMQProducer {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    public  void sendMessage(String message){
        System.out.println("Produced message: " + message + " | " + Thread.currentThread().getName());

        jmsTemplate.convertAndSend("demo-activemq", message);
    }

    public void sendJsonMessage(OrderMessage order) {
        try {
            String json = objectMapper.writeValueAsString(order);

            System.out.println("Producing JSON: " + json);

            jmsTemplate.send("demo.activemqjson", session -> {
                var message = session.createTextMessage(json);

                // Optional: type header (best practice)
                message.setStringProperty("type", "OrderMessage");

                return message;
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
