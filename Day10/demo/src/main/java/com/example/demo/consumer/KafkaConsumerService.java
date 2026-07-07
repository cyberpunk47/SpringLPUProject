package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
class KafkaConsumerService {

    @KafkaListener(topics = "orders", groupId = "myGroup")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}