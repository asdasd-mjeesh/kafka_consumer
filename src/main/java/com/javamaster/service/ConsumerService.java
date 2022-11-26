package com.javamaster.service;

import com.javamaster.model.Message;
import com.javamaster.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private final MessageRepository messageRepository;

    @Autowired
    public ConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "message", groupId = "message_group_id")
    public void consume(Message message) {
        System.out.println(message);
        this.messageRepository.save(message);
    }
}
