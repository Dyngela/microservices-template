package com.diy.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.NotificationEntity;
import com.diy.mapper.NotificationModelMapper;
import com.diy.model.NotificationModel;
import com.diy.repository.NotificationRepository;
import com.diy.twilio.TwilioSmsSender;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {NotificationService.class})
@ExtendWith(SpringExtension.class)
class NotificationServiceTest {
    @MockBean
    private NotificationModelMapper notificationModelMapper;

    @MockBean
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationService notificationService;

    @MockBean(name = "twilio")
    private TwilioSmsSender twilioSmsSender;

    /**
     * Method under test: {@link NotificationService#send(NotificationModel)}
     */
    @Test
    void testSend() {
        NotificationEntity notificationEntity = new NotificationEntity();
        notificationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        notificationEntity.setCustomerId(1L);
        notificationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        notificationEntity.setMessage("Not all who wander are lost");
        notificationEntity.setNotificationId(1L);
        notificationEntity.setPhoneNumber("6625550144");
        notificationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(notificationRepository.save((NotificationEntity) any())).thenReturn(notificationEntity);
        doNothing().when(twilioSmsSender).sendSms((NotificationModel) any());

        NotificationEntity notificationEntity1 = new NotificationEntity();
        notificationEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        notificationEntity1.setCustomerId(1L);
        notificationEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        notificationEntity1.setMessage("Not all who wander are lost");
        notificationEntity1.setNotificationId(1L);
        notificationEntity1.setPhoneNumber("6625550144");
        notificationEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(notificationModelMapper.modelToEntity((NotificationModel) any())).thenReturn(notificationEntity1);
        notificationService.send(new NotificationModel());
        verify(notificationRepository).save((NotificationEntity) any());
        verify(twilioSmsSender).sendSms((NotificationModel) any());
        verify(notificationModelMapper).modelToEntity((NotificationModel) any());
    }
}

