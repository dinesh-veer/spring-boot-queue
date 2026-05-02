package com.dinesh.springbootrabbitmq.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue demoQueue() {
        // The first parameter is the queue name.
        // The second parameter 'true' makes the queue durable (survives broker restarts).
        return new Queue("demo-rabbitmq", true);
    }

    // Creates the JSON queue
    @Bean
    public Queue demoJsonQueue() {
        return new Queue("demo-rabbitmqjson", true);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}