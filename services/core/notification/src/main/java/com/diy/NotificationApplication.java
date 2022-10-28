package com.diy;

import com.diy.config.RabbitMQMessageProducer;
import com.diy.rabbitmq.RabbitConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(
        scanBasePackages = {
                "com.diy.rabbitmq",
                "com.diy"
        }
)
@Configuration
@EnableDiscoveryClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }
}
