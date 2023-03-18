package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.OrderEntity;
import com.diy.entity.PurchaseEntity;
import com.diy.enums.Status;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.OrderModelMapper;
import com.diy.model.OrderModel;
import com.diy.model.PurchaseModel;
import com.diy.repository.OrderRepository;
import com.diy.repository.PurchaseRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderServiceTest {
    @MockBean
    private OrderModelMapper orderModelMapper;

    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderStateService orderStateService;

    @MockBean
    private PurchaseRepository purchaseRepository;

    /**
     * Method under test: {@link OrderService#createOrder(List, Long, Long)}
     */
    @Test
    void testCreateOrder() {
        OrderModel orderModel = new OrderModel();
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(orderModel);
        when(orderModelMapper.purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any())).thenReturn(new ArrayList<>());

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
        when(orderRepository.saveAndFlush((OrderEntity) any())).thenReturn(orderEntity);
        when(purchaseRepository.saveAll((Iterable<PurchaseEntity>) any())).thenReturn(new ArrayList<>());
        assertSame(orderModel, orderService.createOrder(new ArrayList<>(), 1L, 1L));
        verify(orderModelMapper).entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any());
        verify(orderModelMapper).purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any());
        verify(orderRepository).saveAndFlush((OrderEntity) any());
        verify(purchaseRepository).saveAll((Iterable<PurchaseEntity>) any());
    }

    /**
     * Method under test: {@link OrderService#createOrder(List, Long, Long)}
     */
    @Test
    void testCreateOrder2() {
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new OrderModel());
        when(orderModelMapper.purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any())).thenReturn(new ArrayList<>());

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
        when(orderRepository.saveAndFlush((OrderEntity) any())).thenReturn(orderEntity);
        when(purchaseRepository.saveAll((Iterable<PurchaseEntity>) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> orderService.createOrder(new ArrayList<>(), 1L, 1L));
        verify(orderModelMapper).purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any());
        verify(orderRepository).saveAndFlush((OrderEntity) any());
        verify(purchaseRepository).saveAll((Iterable<PurchaseEntity>) any());
    }

    /**
     * Method under test: {@link OrderService#createOrder(List, Long, Long)}
     */
    @Test
    void testCreateOrder3() {
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

        PurchaseEntity purchaseEntity = new PurchaseEntity();
        purchaseEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        purchaseEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        purchaseEntity.setOrder(orderEntity);
        purchaseEntity.setPrice(10.0f);
        purchaseEntity.setProductId(1L);
        purchaseEntity.setPurchaseId(1L);
        purchaseEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<PurchaseEntity> purchaseEntityList = new ArrayList<>();
        purchaseEntityList.add(purchaseEntity);
        OrderModel orderModel = new OrderModel();
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(orderModel);
        when(orderModelMapper.purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any())).thenReturn(purchaseEntityList);

        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setAssignedTo(1L);
        orderEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity1.setCustomerId(1L);
        orderEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity1.setOrderId(1L);
        orderEntity1.setOrderPayed(true);
        orderEntity1.setPurchases(new ArrayList<>());
        orderEntity1.setStatus(Status.waiting);
        orderEntity1.setStoreId(1L);
        orderEntity1.setTotalPrice(10.0f);
        orderEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(orderRepository.saveAndFlush((OrderEntity) any())).thenReturn(orderEntity1);
        when(purchaseRepository.saveAll((Iterable<PurchaseEntity>) any())).thenReturn(new ArrayList<>());
        assertSame(orderModel, orderService.createOrder(new ArrayList<>(), 1L, 1L));
        verify(orderModelMapper).entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any());
        verify(orderModelMapper).purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any());
        verify(orderRepository).saveAndFlush((OrderEntity) any());
        verify(purchaseRepository).saveAll((Iterable<PurchaseEntity>) any());
    }

    /**
     * Method under test: {@link OrderService#createOrder(List, Long, Long)}
     */
    @Test
    void testCreateOrder4() {
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new OrderModel());
        when(orderModelMapper.purchaseModelsToPurchaseEntities((List<PurchaseModel>) any(),
                (CycleAvoidingMappingContext) any())).thenReturn(new ArrayList<>());

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
        when(orderRepository.saveAndFlush((OrderEntity) any())).thenReturn(orderEntity);
        when(purchaseRepository.saveAll((Iterable<PurchaseEntity>) any())).thenReturn(new ArrayList<>());

        ArrayList<PurchaseModel> purchaseModelList = new ArrayList<>();
        purchaseModelList.add(new PurchaseModel());
        assertThrows(ExceptionHandler.class, () -> orderService.createOrder(purchaseModelList, 1L, 1L));
    }

    /**
     * Method under test: {@link OrderService#deleteOrderById(Long)}
     */
    @Test
    void testDeleteOrderById() {
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
        Optional<OrderEntity> ofResult = Optional.of(orderEntity);

        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setAssignedTo(1L);
        orderEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity1.setCustomerId(1L);
        orderEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity1.setOrderId(1L);
        orderEntity1.setOrderPayed(true);
        orderEntity1.setPurchases(new ArrayList<>());
        orderEntity1.setStatus(Status.waiting);
        orderEntity1.setStoreId(1L);
        orderEntity1.setTotalPrice(10.0f);
        orderEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(orderRepository.save((OrderEntity) any())).thenReturn(orderEntity1);
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your order has been deleted", orderService.deleteOrderById(1L));
        verify(orderRepository).save((OrderEntity) any());
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#deleteOrderById(Long)}
     */
    @Test
    void testDeleteOrderById2() {
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
        Optional<OrderEntity> ofResult = Optional.of(orderEntity);
        when(orderRepository.save((OrderEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> orderService.deleteOrderById(1L));
        verify(orderRepository).save((OrderEntity) any());
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrderById(Long)}
     */
    @Test
    void testFindOrderById() {
        OrderModel orderModel = new OrderModel();
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(orderModel);

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
        Optional<OrderEntity> ofResult = Optional.of(orderEntity);
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(orderModel, orderService.findOrderById(1L));
        verify(orderModelMapper).entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any());
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrderById(Long)}
     */
    @Test
    void testFindOrderById2() {
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

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
        Optional<OrderEntity> ofResult = Optional.of(orderEntity);
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> orderService.findOrderById(1L));
        verify(orderModelMapper).entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any());
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrderById(Long)}
     */
    @Test
    void testFindOrderById3() {
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new OrderModel());
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> orderService.findOrderById(1L));
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrdersByCustomerId(Long)}
     */
    @Test
    void testFindOrdersByCustomerId() {
        ArrayList<OrderModel> orderModelList = new ArrayList<>();
        when(orderModelMapper.entitiesToModels((List<OrderEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(orderModelList);
        when(orderRepository.findAllByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        List<OrderModel> actualFindOrdersByCustomerIdResult = orderService.findOrdersByCustomerId(1L);
        assertSame(orderModelList, actualFindOrdersByCustomerIdResult);
        assertTrue(actualFindOrdersByCustomerIdResult.isEmpty());
        verify(orderModelMapper).entitiesToModels((List<OrderEntity>) any(), (CycleAvoidingMappingContext) any());
        verify(orderRepository).findAllByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrdersByCustomerId(Long)}
     */
    @Test
    void testFindOrdersByCustomerId2() {
        when(orderModelMapper.entitiesToModels((List<OrderEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ArrayList<>());
        when(orderRepository.findAllByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> orderService.findOrdersByCustomerId(1L));
        verify(orderRepository).findAllByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrdersByStoreId(Long)}
     */
    @Test
    void testFindOrdersByStoreId() {
        ArrayList<OrderModel> orderModelList = new ArrayList<>();
        when(orderModelMapper.entitiesToModels((List<OrderEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(orderModelList);
        when(orderRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        List<OrderModel> actualFindOrdersByStoreIdResult = orderService.findOrdersByStoreId(1L);
        assertSame(orderModelList, actualFindOrdersByStoreIdResult);
        assertTrue(actualFindOrdersByStoreIdResult.isEmpty());
        verify(orderModelMapper).entitiesToModels((List<OrderEntity>) any(), (CycleAvoidingMappingContext) any());
        verify(orderRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#findOrdersByStoreId(Long)}
     */
    @Test
    void testFindOrdersByStoreId2() {
        when(orderModelMapper.entitiesToModels((List<OrderEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ArrayList<>());
        when(orderRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> orderService.findOrdersByStoreId(1L));
        verify(orderRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#updateOrder(OrderModel)}
     */
    @Test
    void testUpdateOrder() {
        OrderModel orderModel = new OrderModel();
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(orderModel);
        doNothing().when(orderModelMapper)
                .updateOrderFromModel((OrderModel) any(), (OrderEntity) any(), (CycleAvoidingMappingContext) any());

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
        Optional<OrderEntity> ofResult = Optional.of(orderEntity);

        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setAssignedTo(1L);
        orderEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity1.setCustomerId(1L);
        orderEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        orderEntity1.setOrderId(1L);
        orderEntity1.setOrderPayed(true);
        orderEntity1.setPurchases(new ArrayList<>());
        orderEntity1.setStatus(Status.waiting);
        orderEntity1.setStoreId(1L);
        orderEntity1.setTotalPrice(10.0f);
        orderEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(orderRepository.save((OrderEntity) any())).thenReturn(orderEntity1);
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(orderModel, orderService.updateOrder(new OrderModel()));
        verify(orderModelMapper).entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any());
        verify(orderModelMapper).updateOrderFromModel((OrderModel) any(), (OrderEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(orderRepository).save((OrderEntity) any());
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link OrderService#updateOrder(OrderModel)}
     */
    @Test
    void testUpdateOrder2() {
        when(orderModelMapper.entityToModel((OrderEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new OrderModel());
        doNothing().when(orderModelMapper)
                .updateOrderFromModel((OrderModel) any(), (OrderEntity) any(), (CycleAvoidingMappingContext) any());

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
        Optional<OrderEntity> ofResult = Optional.of(orderEntity);
        when(orderRepository.save((OrderEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(orderRepository.findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> orderService.updateOrder(new OrderModel()));
        verify(orderModelMapper).updateOrderFromModel((OrderModel) any(), (OrderEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(orderRepository).save((OrderEntity) any());
        verify(orderRepository).findByOrderIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }
}

