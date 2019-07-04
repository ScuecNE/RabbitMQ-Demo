package com.sugus.rabbitmqtutorial.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class Tut1Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tut1Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello rabbitmq " + new Date();
        amqpTemplate.convertAndSend(queue.getName(), message);
        LOGGER.info(String.format("[Tut1Sender]:%s", message));
    }

}
