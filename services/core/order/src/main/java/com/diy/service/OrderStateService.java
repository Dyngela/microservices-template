package com.diy.service;

import com.diy.config.RabbitMQMessageProducer;
import com.diy.entity.OrderEntity;
import com.diy.enums.Status;
import com.diy.exception.ExceptionHandler;
import com.diy.rabbitmq.NotificationModel;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.diy.enums.Status.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class OrderStateService {
    RabbitMQMessageProducer producer;

    public void handleOrderStatus(OrderEntity orderEntity) {
        switch (orderEntity.getStatus()) {
            case payed -> orderPayed(orderEntity);
            case problematic -> orderProblematic(orderEntity);
            case ready -> orderReady(orderEntity);
            default -> throw new ExceptionHandler("Unable to update your order's status");
        }
    }

    private void orderReady(OrderEntity orderEntity) {
        producer.publish(
                new NotificationModel(orderEntity.getCustomerId(), "Your order is ready at our store", "+33 7 70 17 98 18"),
                "internal.exchange",
                "internal.notification.routing-key"
                );
    }

    private void orderPayed(OrderEntity orderEntity) {
        // todo doit on faire qqch ici réellement? ou on gère sur le front
    }

    private void orderProblematic(OrderEntity orderEntity) {
        producer.publish(
                new NotificationModel(orderEntity.getCustomerId(), "Your order have a problem, you will be contacted soon by your vendor", "+33 7 70 17 98 18"),
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }

}
