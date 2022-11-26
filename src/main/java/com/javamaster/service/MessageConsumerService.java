package com.javamaster.service;

import com.javamaster.entity.Message;

public interface MessageConsumerService {

    String consume(Message message);
}
