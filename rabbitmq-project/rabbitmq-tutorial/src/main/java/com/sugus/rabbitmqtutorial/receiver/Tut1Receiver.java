package com.sugus.rabbitmqtutorial.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello-world")
public class Tut1Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tut1Receiver.class);

    @RabbitHandler
    public void receive(String message) {
        LOGGER.info(String.format("[Tut1Receiver]:%s", message));
    }

}
