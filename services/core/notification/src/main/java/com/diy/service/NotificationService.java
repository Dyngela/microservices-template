package com.diy.service;

import com.diy.entity.NotificationEntity;
import com.diy.mapper.NotificationModelMapper;
import com.diy.model.NotificationModel;
import com.diy.repository.NotificationRepository;
import com.diy.twilio.TwilioSmsSender;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Log4j2
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final TwilioSmsSender smsSender;
    private final NotificationModelMapper modelMapper;

    public void send(NotificationModel request) {
        log.warn("Sending sms: " + request);
        smsSender.sendSms(request);
        NotificationEntity entity = modelMapper.modelToEntity(request);
        entity.setCreatedAt(LocalDateTime.now());
        notificationRepository.save(entity);
    }

    @KafkaListener(topics = "notification-service", groupId = "com.diy")
    public void listenForNotification(NotificationModel model) {
        send(model);
    }
}
