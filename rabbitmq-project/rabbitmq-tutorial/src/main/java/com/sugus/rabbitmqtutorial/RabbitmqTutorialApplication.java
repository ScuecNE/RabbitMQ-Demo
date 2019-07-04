package com.sugus.rabbitmqtutorial;

import com.sugus.rabbitmqtutorial.runner.RabbitTutorialRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqTutorialApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitmqTutorialApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(RabbitmqTutorialApplication.class)
                // 设置成非 web 环境
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Profile("usage_message")
    @Bean
    public CommandLineRunner usage() {
        return arg0 -> {
            LOGGER.info("This app uses Spring Profiles to control its behavior.\n");
            LOGGER.info("Sample usage: java -jar target/rabbitmq-tutorial-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender");
        };
    }

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitTutorialRunner();
    }

}
