package com.javamaster.service;

import com.javamaster.entity.Message;
import com.javamaster.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MassageKafkaListenerService {
    private final MessageRepository messageRepository;

    @Autowired
    public MassageKafkaListenerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "message", groupId = "message_group_id")
    public String consume(Message message) {
        System.out.println(message);
        this.messageRepository.save(message);
        return "ASDSDSAD";
    }
}
