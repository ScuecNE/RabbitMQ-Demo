package com.sugus.rabbitmqtutorial.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

public class RabbitTutorialRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitTutorialRunner.class);

    @Value("${tutorial.client.duration:0}")
    private int duration;

    @Autowired
    private ConfigurableApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Ready ... running for " + duration + "ms");
        Thread.sleep(duration);
        ctx.close();

    }
}
