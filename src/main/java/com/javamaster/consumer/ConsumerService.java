package com.javamaster.consumer;

import com.javamaster.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "message", groupId = "message_group_id")
    public void consume(Message message) {
        System.out.println(message);
    }
}
