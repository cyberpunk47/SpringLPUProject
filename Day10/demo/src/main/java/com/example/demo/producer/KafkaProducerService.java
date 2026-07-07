package com.example.demo.producer;

import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "orders";
    private static final long SEND_TIMEOUT_SECONDS = 3;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        try {
            kafkaTemplate.send(TOPIC, message).get(SEND_TIMEOUT_SECONDS, TimeUnit.SECONDS);
            System.out.println("Sent message: " + message);
        } catch (Exception exception) {
            throw new IllegalStateException("Failed to send message to Kafka", exception);
        }
    }
}
