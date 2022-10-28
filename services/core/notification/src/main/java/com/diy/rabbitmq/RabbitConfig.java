package com.diy.rabbitmq;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RabbitConfig {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-key.internal-notification}")
    private String internalNotificationRoutingKeyExchange;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    public Queue notificationQueue() {
        return new Queue(this.notificationQueue);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder.bind(notificationQueue())
                .to(internalTopicExchange())
                .with(this.internalNotificationRoutingKeyExchange);
    }

}