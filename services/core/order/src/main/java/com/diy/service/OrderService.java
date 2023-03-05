package com.diy.service;

import com.diy.entity.OrderEntity;
import com.diy.entity.PurchaseEntity;
import com.diy.enums.Status;
import com.diy.exception.ExceptionHandler;
import com.diy.generated.model.OrderStatusDto;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.OrderModelMapper;
import com.diy.model.OrderModel;
import com.diy.model.PurchaseModel;
import com.diy.repository.OrderRepository;
import com.diy.repository.PurchaseRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class gOrderService {

    OrderModelMapper orderMapper;
    OrderRepository orderRepository;
    OrderStateService orderStateService;
    PurchaseRepository purchaseRepository;

    public OrderModel findOrderById(Long orderId) {
        try {
            OrderEntity orderEntity = orderRepository.findByOrderIdAndDeletedAt(orderId, null).orElseThrow(
                    () -> new ExceptionHandler("We could not find your order"));
            return orderMapper.entityToModel(orderEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("We could not find order by orderId: " + e.getMessage());
            throw new ExceptionHandler("We could not find your order");
        }
    }

    public List<OrderModel> findOrdersByCustomerId(Long customerId) {
        try {
            List<OrderEntity> orderEntities = orderRepository.findAllByCustomerIdAndDeletedAt(customerId, null);
            return orderMapper.entitiesToModels(orderEntities, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("We could not find orders by customerId: " + e.getMessage());
            throw new ExceptionHandler("We could not find your orders");
        }
    }



    public List<OrderModel> findOrdersByStoreId(Long storeid) {
        try {
            List<OrderEntity> orderEntities = orderRepository.findAllByStoreIdAndDeletedAt(storeid, null);
            return orderMapper.entitiesToModels(orderEntities, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("We could not find orders by storeId: " + e.getMessage());
            throw new ExceptionHandler("We could not find your orders");
        }
    }

    public OrderModel updateOrder(OrderModel orderModel) {
        try {
            OrderEntity orderEntity = orderRepository.findByOrderIdAndDeletedAt(orderModel.getOrderId(), null).orElseThrow(
                    () -> new ExceptionHandler("We could not find your order"));
            orderMapper.updateOrderFromModel(orderModel, orderEntity, new CycleAvoidingMappingContext());
            orderEntity.setUpdatedAt(LocalDateTime.now());
            orderRepository.save(orderEntity);
            return orderMapper.entityToModel(orderEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("We could not update order: " + e.getMessage());
            log.error("Order model: " + orderModel.toString());
            throw new ExceptionHandler("We could not update your order");
        }
    }

    public String changeOrderStatus(OrderStatusDto orderStatusDto) {
        try {
            OrderEntity orderEntity = orderRepository.findByOrderIdAndDeletedAt(orderStatusDto.getOrderId(), null).orElseThrow(
                    () -> new ExceptionHandler("We could not find your order"));
            orderEntity.setUpdatedAt(LocalDateTime.now());
            orderEntity.setStatus(Status.valueOf(orderStatusDto.getStatus()));
            orderRepository.save(orderEntity);
            orderStateService.handleOrderStatus(orderEntity);
            return "Order status updated.";
        } catch (Exception e) {
            log.error("We could not update order status: " + e.getMessage());
            throw new ExceptionHandler("We could not update your order");
        }
    }

    public OrderModel createOrder(List<PurchaseModel> purchaseModels, Long storeId, Long customerId) {
        try {
            OrderEntity orderEntity = new OrderEntity();
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.CEILING);
            float orderPrice = 0;

            for (PurchaseModel purchaseModel : purchaseModels) {
                orderPrice += purchaseModel.getPrice();
            }

            orderEntity.setTotalPrice(Float.parseFloat(df.format(orderPrice)));
            orderEntity.setOrderPayed(false);
            orderEntity.setCreatedAt(LocalDateTime.now());
            orderEntity.setStatus(Status.waiting);
            orderEntity.setCustomerId(customerId);
            orderEntity.setStoreId(storeId);
            OrderEntity savedOrder = orderRepository.saveAndFlush(orderEntity);

            List<PurchaseEntity> purchaseEntities = orderMapper.purchaseModelsToPurchaseEntities(purchaseModels, new CycleAvoidingMappingContext());
            for (PurchaseEntity p : purchaseEntities) {
                p.setCreatedAt(LocalDateTime.now());
                p.setOrder(savedOrder);
            }
            purchaseRepository.saveAll(purchaseEntities);

            return orderMapper.entityToModel(orderEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("We could not create order: " + e.getMessage());
            log.error("Order model: " + purchaseModels.toString());
            throw new ExceptionHandler("We could not create your order");
        }
    }

    public String deleteOrderById(Long orderId) {
        try {
            OrderEntity categoryEntity = orderRepository.findByOrderIdAndDeletedAt(orderId, null).orElseThrow(() ->
                    new ExceptionHandler("We could not find your order"));
            categoryEntity.setUpdatedAt(LocalDateTime.now());
            categoryEntity.setDeletedAt(LocalDateTime.now());
            orderRepository.save(categoryEntity);
            return "Your order has been deleted";
        } catch (Exception e) {
            log.error("Error while deleting an order: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your order");
        }
    }

}

