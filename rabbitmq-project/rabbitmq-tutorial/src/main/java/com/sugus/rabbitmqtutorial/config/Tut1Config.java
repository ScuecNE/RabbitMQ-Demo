package com.sugus.rabbitmqtutorial.config;

import com.sugus.rabbitmqtutorial.receiver.Tut1Receiver;
import com.sugus.rabbitmqtutorial.sender.Tut1Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1", "hello-world"})
@Configuration
public class Tut1Config {

    @Bean
    public Queue queue() {
        return new Queue("hello-world");
    }

    @Profile("receiver")
    @Bean
    public Tut1Receiver receiver() {
        return new Tut1Receiver();
    }

    @Profile("sender")
    @Bean
    public Tut1Sender sender() {
        return new Tut1Sender();
    }

}
