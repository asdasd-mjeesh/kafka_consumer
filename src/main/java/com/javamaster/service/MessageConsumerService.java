package com.javamaster.service;

import com.javamaster.model.Message;

public interface MessageConsumerService {

    String consume(Message message);
}
