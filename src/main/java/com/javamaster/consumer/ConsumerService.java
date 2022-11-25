package com.javamaster.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "message", groupId = "message_group_id")
    public void consume(String message) {
        System.out.println(message);
    }
}
