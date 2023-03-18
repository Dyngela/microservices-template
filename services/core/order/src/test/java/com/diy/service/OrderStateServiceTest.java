package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.OrderEntity;
import com.diy.entity.PurchaseEntity;
import com.diy.enums.Status;
import com.diy.exception.ExceptionHandler;
import com.diy.rabbitMQ.RabbitMQMessageProducer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderStateService.class})
@ExtendWith(SpringExtension.class)
class OrderStateServiceTest {
    @Autowired
    private OrderStateService orderStateService;

    @MockBean
    private RabbitMQMessageProducer rabbitMQMessageProducer;

    /**
     * Method under test: {@link OrderStateService#handleOrderStatus(OrderEntity)}
     */
    @Test
    void testHandleOrderStatus() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAssignedTo(1L);
        orderEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity.setCustomerId(1L);
        orderEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity.setOrderId(1L);
        orderEntity.setOrderPayed(true);
        orderEntity.setPurchases(new ArrayList<>());
        orderEntity.setStatus(Status.waiting);
        orderEntity.setStoreId(1L);
        orderEntity.setTotalPrice(10.0f);
        orderEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        assertThrows(ExceptionHandler.class, () -> orderStateService.handleOrderStatus(orderEntity));
    }

    /**
     * Method under test: {@link OrderStateService#handleOrderStatus(OrderEntity)}
     */
    @Test
    void testHandleOrderStatus2() {
        doNothing().when(rabbitMQMessageProducer).publish((Object) any(), (String) any(), (String) any());
        OrderEntity orderEntity = mock(OrderEntity.class);
        when(orderEntity.getCustomerId()).thenReturn(1L);
        when(orderEntity.getStatus()).thenReturn(Status.ready);
        doNothing().when(orderEntity).setAssignedTo((Long) any());
        doNothing().when(orderEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(orderEntity).setCustomerId((Long) any());
        doNothing().when(orderEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(orderEntity).setOrderId((Long) any());
        doNothing().when(orderEntity).setOrderPayed((Boolean) any());
        doNothing().when(orderEntity).setPurchases((List<PurchaseEntity>) any());
        doNothing().when(orderEntity).setStatus((Status) any());
        doNothing().when(orderEntity).setStoreId((Long) any());
        doNothing().when(orderEntity).setTotalPrice((Float) any());
        doNothing().when(orderEntity).setUpdatedAt((LocalDateTime) any());
        orderEntity.setAssignedTo(1L);
        orderEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity.setCustomerId(1L);
        orderEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity.setOrderId(1L);
        orderEntity.setOrderPayed(true);
        orderEntity.setPurchases(new ArrayList<>());
        orderEntity.setStatus(Status.waiting);
        orderEntity.setStoreId(1L);
        orderEntity.setTotalPrice(10.0f);
        orderEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderStateService.handleOrderStatus(orderEntity);
        verify(rabbitMQMessageProducer).publish((Object) any(), (String) any(), (String) any());
        verify(orderEntity).getStatus();
        verify(orderEntity).getCustomerId();
        verify(orderEntity).setAssignedTo((Long) any());
        verify(orderEntity).setCreatedAt((LocalDateTime) any());
        verify(orderEntity).setCustomerId((Long) any());
        verify(orderEntity).setDeletedAt((LocalDateTime) any());
        verify(orderEntity).setOrderId((Long) any());
        verify(orderEntity).setOrderPayed((Boolean) any());
        verify(orderEntity).setPurchases((List<PurchaseEntity>) any());
        verify(orderEntity).setStatus((Status) any());
        verify(orderEntity).setStoreId((Long) any());
        verify(orderEntity).setTotalPrice((Float) any());
        verify(orderEntity).setUpdatedAt((LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderStateService#handleOrderStatus(OrderEntity)}
     */
    @Test
    void testHandleOrderStatus3() {
        doNothing().when(rabbitMQMessageProducer).publish((Object) any(), (String) any(), (String) any());
        OrderEntity orderEntity = mock(OrderEntity.class);
        when(orderEntity.getCustomerId()).thenThrow(new ExceptionHandler("An error occurred"));
        when(orderEntity.getStatus()).thenReturn(Status.ready);
        doNothing().when(orderEntity).setAssignedTo((Long) any());
        doNothing().when(orderEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(orderEntity).setCustomerId((Long) any());
        doNothing().when(orderEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(orderEntity).setOrderId((Long) any());
        doNothing().when(orderEntity).setOrderPayed((Boolean) any());
        doNothing().when(orderEntity).setPurchases((List<PurchaseEntity>) any());
        doNothing().when(orderEntity).setStatus((Status) any());
        doNothing().when(orderEntity).setStoreId((Long) any());
        doNothing().when(orderEntity).setTotalPrice((Float) any());
        doNothing().when(orderEntity).setUpdatedAt((LocalDateTime) any());
        orderEntity.setAssignedTo(1L);
        orderEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity.setCustomerId(1L);
        orderEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity.setOrderId(1L);
        orderEntity.setOrderPayed(true);
        orderEntity.setPurchases(new ArrayList<>());
        orderEntity.setStatus(Status.waiting);
        orderEntity.setStoreId(1L);
        orderEntity.setTotalPrice(10.0f);
        orderEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        assertThrows(ExceptionHandler.class, () -> orderStateService.handleOrderStatus(orderEntity));
        verify(orderEntity).getStatus();
        verify(orderEntity).getCustomerId();
        verify(orderEntity).setAssignedTo((Long) any());
        verify(orderEntity).setCreatedAt((LocalDateTime) any());
        verify(orderEntity).setCustomerId((Long) any());
        verify(orderEntity).setDeletedAt((LocalDateTime) any());
        verify(orderEntity).setOrderId((Long) any());
        verify(orderEntity).setOrderPayed((Boolean) any());
        verify(orderEntity).setPurchases((List<PurchaseEntity>) any());
        verify(orderEntity).setStatus((Status) any());
        verify(orderEntity).setStoreId((Long) any());
        verify(orderEntity).setTotalPrice((Float) any());
        verify(orderEntity).setUpdatedAt((LocalDateTime) any());
    }
}

