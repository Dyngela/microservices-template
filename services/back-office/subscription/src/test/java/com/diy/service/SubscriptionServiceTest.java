package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.SubscriptionEntity;
import com.diy.entity.SubscriptionTypeEntity;
import com.diy.enums.PaymentType;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.SubscriptionModelMapper;
import com.diy.model.SubscriptionModel;
import com.diy.repository.SubscriptionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubscriptionService.class})
@ExtendWith(SpringExtension.class)
class SubscriptionServiceTest {
    @MockBean
    private SubscriptionModelMapper subscriptionModelMapper;

    @MockBean
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    /**
     * Method under test: {@link SubscriptionService#createSubscription(SubscriptionModel)}
     */
    @Test
    void testCreateSubscription() {
        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("Name");
        subscriptionTypeEntity.setPrice(10.0f);
        subscriptionTypeEntity.setSubscriptionTypeId(1L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("Support");
        subscriptionTypeEntity.setTurnover(10.0d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setPaymentType(PaymentType.monthly);
        subscriptionEntity.setStoreId(1L);
        subscriptionEntity.setSubscriptionId(1L);
        subscriptionEntity.setSubscriptionType(subscriptionTypeEntity);
        subscriptionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(subscriptionRepository.save((SubscriptionEntity) any())).thenReturn(subscriptionEntity);

        SubscriptionTypeEntity subscriptionTypeEntity1 = new SubscriptionTypeEntity();
        subscriptionTypeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity1.setName("Name");
        subscriptionTypeEntity1.setPrice(10.0f);
        subscriptionTypeEntity1.setSubscriptionTypeId(1L);
        subscriptionTypeEntity1.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity1.setSupport("Support");
        subscriptionTypeEntity1.setTurnover(10.0d);
        subscriptionTypeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity1 = new SubscriptionEntity();
        subscriptionEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setPaymentType(PaymentType.monthly);
        subscriptionEntity1.setStoreId(1L);
        subscriptionEntity1.setSubscriptionId(1L);
        subscriptionEntity1.setSubscriptionType(subscriptionTypeEntity1);
        subscriptionEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(subscriptionModelMapper.modelToEntity((SubscriptionModel) any())).thenReturn(subscriptionEntity1);
        assertEquals("Your subscription have been taken in account",
                subscriptionService.createSubscription(new SubscriptionModel()));
        verify(subscriptionRepository).save((SubscriptionEntity) any());
        verify(subscriptionModelMapper).modelToEntity((SubscriptionModel) any());
    }

    /**
     * Method under test: {@link SubscriptionService#createSubscription(SubscriptionModel)}
     */
    @Test
    void testCreateSubscription2() {
        when(subscriptionRepository.save((SubscriptionEntity) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("Name");
        subscriptionTypeEntity.setPrice(10.0f);
        subscriptionTypeEntity.setSubscriptionTypeId(1L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("Support");
        subscriptionTypeEntity.setTurnover(10.0d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setPaymentType(PaymentType.monthly);
        subscriptionEntity.setStoreId(1L);
        subscriptionEntity.setSubscriptionId(1L);
        subscriptionEntity.setSubscriptionType(subscriptionTypeEntity);
        subscriptionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(subscriptionModelMapper.modelToEntity((SubscriptionModel) any())).thenReturn(subscriptionEntity);
        assertThrows(ExceptionHandler.class, () -> subscriptionService.createSubscription(new SubscriptionModel()));
        verify(subscriptionRepository).save((SubscriptionEntity) any());
        verify(subscriptionModelMapper).modelToEntity((SubscriptionModel) any());
    }

    /**
     * Method under test: {@link SubscriptionService#updateSubscription(SubscriptionModel)}
     */
    @Test
    void testUpdateSubscription() {
        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("Name");
        subscriptionTypeEntity.setPrice(10.0f);
        subscriptionTypeEntity.setSubscriptionTypeId(1L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("Support");
        subscriptionTypeEntity.setTurnover(10.0d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setPaymentType(PaymentType.monthly);
        subscriptionEntity.setStoreId(1L);
        subscriptionEntity.setSubscriptionId(1L);
        subscriptionEntity.setSubscriptionType(subscriptionTypeEntity);
        subscriptionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<SubscriptionEntity> ofResult = Optional.of(subscriptionEntity);

        SubscriptionTypeEntity subscriptionTypeEntity1 = new SubscriptionTypeEntity();
        subscriptionTypeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity1.setName("Name");
        subscriptionTypeEntity1.setPrice(10.0f);
        subscriptionTypeEntity1.setSubscriptionTypeId(1L);
        subscriptionTypeEntity1.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity1.setSupport("Support");
        subscriptionTypeEntity1.setTurnover(10.0d);
        subscriptionTypeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity1 = new SubscriptionEntity();
        subscriptionEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setPaymentType(PaymentType.monthly);
        subscriptionEntity1.setStoreId(1L);
        subscriptionEntity1.setSubscriptionId(1L);
        subscriptionEntity1.setSubscriptionType(subscriptionTypeEntity1);
        subscriptionEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(subscriptionRepository.save((SubscriptionEntity) any())).thenReturn(subscriptionEntity1);
        when(subscriptionRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(subscriptionModelMapper)
                .updateCustomerFromModel((SubscriptionModel) any(), (SubscriptionEntity) any(),
                        (CycleAvoidingMappingContext) any());
        assertEquals("Your subscription have been updated",
                subscriptionService.updateSubscription(new SubscriptionModel()));
        verify(subscriptionRepository).save((SubscriptionEntity) any());
        verify(subscriptionRepository).findById((Long) any());
        verify(subscriptionModelMapper).updateCustomerFromModel((SubscriptionModel) any(), (SubscriptionEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link SubscriptionService#updateSubscription(SubscriptionModel)}
     */
    @Test
    void testUpdateSubscription2() {
        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("Name");
        subscriptionTypeEntity.setPrice(10.0f);
        subscriptionTypeEntity.setSubscriptionTypeId(1L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("Support");
        subscriptionTypeEntity.setTurnover(10.0d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setPaymentType(PaymentType.monthly);
        subscriptionEntity.setStoreId(1L);
        subscriptionEntity.setSubscriptionId(1L);
        subscriptionEntity.setSubscriptionType(subscriptionTypeEntity);
        subscriptionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<SubscriptionEntity> ofResult = Optional.of(subscriptionEntity);

        SubscriptionTypeEntity subscriptionTypeEntity1 = new SubscriptionTypeEntity();
        subscriptionTypeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity1.setName("Name");
        subscriptionTypeEntity1.setPrice(10.0f);
        subscriptionTypeEntity1.setSubscriptionTypeId(1L);
        subscriptionTypeEntity1.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity1.setSupport("Support");
        subscriptionTypeEntity1.setTurnover(10.0d);
        subscriptionTypeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity1 = new SubscriptionEntity();
        subscriptionEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity1.setPaymentType(PaymentType.monthly);
        subscriptionEntity1.setStoreId(1L);
        subscriptionEntity1.setSubscriptionId(1L);
        subscriptionEntity1.setSubscriptionType(subscriptionTypeEntity1);
        subscriptionEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(subscriptionRepository.save((SubscriptionEntity) any())).thenReturn(subscriptionEntity1);
        when(subscriptionRepository.findById((Long) any())).thenReturn(ofResult);
        doThrow(new ExceptionHandler("An error occurred")).when(subscriptionModelMapper)
                .updateCustomerFromModel((SubscriptionModel) any(), (SubscriptionEntity) any(),
                        (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> subscriptionService.updateSubscription(new SubscriptionModel()));
        verify(subscriptionRepository).findById((Long) any());
        verify(subscriptionModelMapper).updateCustomerFromModel((SubscriptionModel) any(), (SubscriptionEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link SubscriptionService#getStoreSubscription(Long)}
     */
    @Test
    void testGetStoreSubscription() {
        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("Name");
        subscriptionTypeEntity.setPrice(10.0f);
        subscriptionTypeEntity.setSubscriptionTypeId(1L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("Support");
        subscriptionTypeEntity.setTurnover(10.0d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setPaymentType(PaymentType.monthly);
        subscriptionEntity.setStoreId(1L);
        subscriptionEntity.setSubscriptionId(1L);
        subscriptionEntity.setSubscriptionType(subscriptionTypeEntity);
        subscriptionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<SubscriptionEntity> ofResult = Optional.of(subscriptionEntity);
        when(subscriptionRepository.findByStoreId((Long) any())).thenReturn(ofResult);
        SubscriptionModel subscriptionModel = new SubscriptionModel();
        when(subscriptionModelMapper.entityToModel((SubscriptionEntity) any())).thenReturn(subscriptionModel);
        assertSame(subscriptionModel, subscriptionService.getStoreSubscription(1L));
        verify(subscriptionRepository).findByStoreId((Long) any());
        verify(subscriptionModelMapper).entityToModel((SubscriptionEntity) any());
    }

    /**
     * Method under test: {@link SubscriptionService#getStoreSubscription(Long)}
     */
    @Test
    void testGetStoreSubscription2() {
        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("Name");
        subscriptionTypeEntity.setPrice(10.0f);
        subscriptionTypeEntity.setSubscriptionTypeId(1L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("Support");
        subscriptionTypeEntity.setTurnover(10.0d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateEnd(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDateStart(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionEntity.setPaymentType(PaymentType.monthly);
        subscriptionEntity.setStoreId(1L);
        subscriptionEntity.setSubscriptionId(1L);
        subscriptionEntity.setSubscriptionType(subscriptionTypeEntity);
        subscriptionEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<SubscriptionEntity> ofResult = Optional.of(subscriptionEntity);
        when(subscriptionRepository.findByStoreId((Long) any())).thenReturn(ofResult);
        when(subscriptionModelMapper.entityToModel((SubscriptionEntity) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> subscriptionService.getStoreSubscription(1L));
        verify(subscriptionRepository).findByStoreId((Long) any());
        verify(subscriptionModelMapper).entityToModel((SubscriptionEntity) any());
    }
}

