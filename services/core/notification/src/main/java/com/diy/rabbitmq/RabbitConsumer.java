package com.diy.rabbitmq;

import com.diy.model.NotificationModel;
import com.diy.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Log4j2
public class RabbitConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationModel notificationRequest) {
        log.info("Consumed {} from queue", notificationRequest.toString());
//        notificationService.send(notificationRequest);
    }
}
