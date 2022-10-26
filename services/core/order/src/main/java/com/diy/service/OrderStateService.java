package com.diy.service;

import com.diy.entity.OrderEntity;
import com.diy.kafka.NotificationModel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class OrderStateService {

    KafkaTemplate<String, NotificationModel> kafkaTemplate;


    public void orderReady(OrderEntity orderEntity) {
        kafkaTemplate.send("notification-service", new NotificationModel(orderEntity.getCustomerId(), "Your order is ready at our store", "+33 7 70 17 98 18"));
    }

}
