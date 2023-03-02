package com.diy.rabbit;

import com.diy.model.NotificationModel;
import com.diy.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @Bean
    Queue queue() {
        return new Queue("notification.queue");
    }

    @RabbitListener(queues = "notification.queue")
    public void consumer(NotificationModel notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }

}
