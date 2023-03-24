package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.OrderDto;
import com.diy.generated.model.OrderStatusDto;
import com.diy.generated.model.OrderWithoutPurchaseDto;
import com.diy.generated.model.PurchaseWithoutOrderDto;
import com.diy.mapper.OrderModelMapper;
import com.diy.model.OrderModel;
import com.diy.model.PurchaseModel;
import com.diy.service.OrderService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderApiImpl.class})
@ExtendWith(SpringExtension.class)
class OrderApiImplTest {
    @Autowired
    private OrderApiImpl orderApiImpl;

    @MockBean
    private OrderModelMapper orderModelMapper;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderApiImpl#createOrder(Long, Long, List)}
     */
    @Test
    void testCreateOrder() {
        when(orderModelMapper.modelToOrderWithoutPurchaseDto((OrderModel) any())).thenReturn(new OrderWithoutPurchaseDto());
        when(orderModelMapper.purchaseWithoutOrderDtoToPurchaseModel((List<PurchaseWithoutOrderDto>) any()))
                .thenReturn(new ArrayList<>());
        when(orderService.createOrder((List<PurchaseModel>) any(), (Long) any(), (Long) any()))
                .thenReturn(new OrderModel());
        ResponseEntity<OrderWithoutPurchaseDto> actualCreateOrderResult = orderApiImpl.createOrder(1L, 1L,
                new ArrayList<>());
        assertTrue(actualCreateOrderResult.hasBody());
        assertTrue(actualCreateOrderResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualCreateOrderResult.getStatusCode());
        verify(orderModelMapper).modelToOrderWithoutPurchaseDto((OrderModel) any());
        verify(orderModelMapper).purchaseWithoutOrderDtoToPurchaseModel((List<PurchaseWithoutOrderDto>) any());
        verify(orderService).createOrder((List<PurchaseModel>) any(), (Long) any(), (Long) any());
    }

    /**
     * Method under test: {@link OrderApiImpl#deleteOrderById(Long)}
     */
    @Test
    void testDeleteOrderById() {
        when(orderService.deleteOrderById((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteOrderByIdResult = orderApiImpl.deleteOrderById(1L);
        assertEquals("42", actualDeleteOrderByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteOrderByIdResult.getStatusCode());
        assertTrue(actualDeleteOrderByIdResult.getHeaders().isEmpty());
        verify(orderService).deleteOrderById((Long) any());
    }

    /**
     * Method under test: {@link OrderApiImpl#findOrderById(Long)}
     */
    @Test
    void testFindOrderById() {
        when(orderModelMapper.modelToDto((OrderModel) any())).thenReturn(new OrderDto());
        when(orderService.findOrderById((Long) any())).thenReturn(new OrderModel());
        ResponseEntity<OrderDto> actualFindOrderByIdResult = orderApiImpl.findOrderById(1L);
        assertTrue(actualFindOrderByIdResult.hasBody());
        assertTrue(actualFindOrderByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindOrderByIdResult.getStatusCode());
        verify(orderModelMapper).modelToDto((OrderModel) any());
        verify(orderService).findOrderById((Long) any());
    }

    /**
     * Method under test: {@link OrderApiImpl#findOrdersByCustomerId(Long)}
     */
    @Test
    void testFindOrdersByCustomerId() {
        when(orderModelMapper.modelToOrderWithoutPurchaseDto((List<OrderModel>) any())).thenReturn(new ArrayList<>());
        ArrayList<OrderModel> orderModelList = new ArrayList<>();
        when(orderService.findOrdersByCustomerId((Long) any())).thenReturn(orderModelList);
        ResponseEntity<List<OrderWithoutPurchaseDto>> actualFindOrdersByCustomerIdResult = orderApiImpl
                .findOrdersByCustomerId(1L);
        assertEquals(orderModelList, actualFindOrdersByCustomerIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindOrdersByCustomerIdResult.getStatusCode());
        assertTrue(actualFindOrdersByCustomerIdResult.getHeaders().isEmpty());
        verify(orderModelMapper).modelToOrderWithoutPurchaseDto((List<OrderModel>) any());
        verify(orderService).findOrdersByCustomerId((Long) any());
    }

    /**
     * Method under test: {@link OrderApiImpl#findOrdersByStoreId(Long)}
     */
    @Test
    void testFindOrdersByStoreId() {
        when(orderModelMapper.modelToOrderWithoutPurchaseDto((List<OrderModel>) any())).thenReturn(new ArrayList<>());
        ArrayList<OrderModel> orderModelList = new ArrayList<>();
        when(orderService.findOrdersByStoreId((Long) any())).thenReturn(orderModelList);
        ResponseEntity<List<OrderWithoutPurchaseDto>> actualFindOrdersByStoreIdResult = orderApiImpl
                .findOrdersByStoreId(1L);
        assertEquals(orderModelList, actualFindOrdersByStoreIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindOrdersByStoreIdResult.getStatusCode());
        assertTrue(actualFindOrdersByStoreIdResult.getHeaders().isEmpty());
        verify(orderModelMapper).modelToOrderWithoutPurchaseDto((List<OrderModel>) any());
        verify(orderService).findOrdersByStoreId((Long) any());
    }

    /**
     * Method under test: {@link OrderApiImpl#updateOrder(OrderDto)}
     */
    @Test
    void testUpdateOrder() {
        when(orderModelMapper.modelToDto((OrderModel) any())).thenReturn(new OrderDto());
        when(orderModelMapper.dtoToModel((OrderDto) any())).thenReturn(new OrderModel());
        when(orderService.updateOrder((OrderModel) any())).thenReturn(new OrderModel());
        OrderDto orderDto = new OrderDto();
        ResponseEntity<OrderDto> actualUpdateOrderResult = orderApiImpl.updateOrder(orderDto);
        assertEquals(orderDto, actualUpdateOrderResult.getBody());
        assertTrue(actualUpdateOrderResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateOrderResult.getStatusCode());
        verify(orderModelMapper).modelToDto((OrderModel) any());
        verify(orderModelMapper).dtoToModel((OrderDto) any());
        verify(orderService).updateOrder((OrderModel) any());
    }

    /**
     * Method under test: {@link OrderApiImpl#updateOrderStatus(OrderStatusDto)}
     */
    @Test
    void testUpdateOrderStatus() {
        when(orderService.changeOrderStatus((OrderStatusDto) any())).thenReturn("Change Order Status");
        ResponseEntity<String> actualUpdateOrderStatusResult = orderApiImpl.updateOrderStatus(new OrderStatusDto());
        assertEquals("Change Order Status", actualUpdateOrderStatusResult.getBody());
        assertEquals(HttpStatus.OK, actualUpdateOrderStatusResult.getStatusCode());
        assertTrue(actualUpdateOrderStatusResult.getHeaders().isEmpty());
        verify(orderService).changeOrderStatus((OrderStatusDto) any());
    }
}

