package com.diy.service;

import com.diy.entity.SubscriptionEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.SubscriptionModelMapper;
import com.diy.model.SubscriptionModel;
import com.diy.repository.SubscriptionRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class SubscriptionService {

    SubscriptionRepository repository;
    SubscriptionModelMapper modelMapper;

    public String createSubscription(SubscriptionModel model) {
        try {
            SubscriptionEntity entity = modelMapper.modelToEntity(model);
            switch (entity.getPaymentType()) {
                case monthly -> entity.setDateEnd(LocalDateTime.now().plusMonths(1));
                case weekly -> entity.setDateEnd(LocalDateTime.now().plusWeeks(1));
                case yearly -> entity.setDateEnd(LocalDateTime.now().plusYears(1));
            }
            entity.setDateStart(LocalDateTime.now());
            entity.setCreatedAt(LocalDateTime.now());
            entity.setDateStart(LocalDateTime.now());
            repository.save(entity);
            return "Your subscription have been taken in account";
        } catch (Exception e) {
            log.error("Error while creating subscription : " +  e.getMessage());
            throw new ExceptionHandler("We could not create your subscription, retry later please");
        }
    }
    // TODO give back money if the invoice rate change for lower.
    // Since payment part is fake we don't.
    public String  updateSubscription(SubscriptionModel model) {
        try {
            SubscriptionEntity entity = repository.findById(model.getSubscriptionId()).orElseThrow(()
                    -> new ExceptionHandler("We could not update your subscription"));
            modelMapper.updateCustomerFromModel(model, entity, new CycleAvoidingMappingContext());
            entity.setDateStart(LocalDateTime.now());
            entity.setUpdatedAt(LocalDateTime.now());
            switch (entity.getPaymentType()) {
                case monthly -> entity.setDateEnd(LocalDateTime.now().plusMonths(1));
                case weekly -> entity.setDateEnd(LocalDateTime.now().plusWeeks(1));
                case yearly -> entity.setDateEnd(LocalDateTime.now().plusYears(1));
            }
            repository.save(entity);
            return "Your subscription have been updated";
        } catch (Exception e) {
            log.error("Error while updating subscription : " +  e.getMessage());
            throw new ExceptionHandler("We could not update your subscription, retry later please");
        }
    }

    public SubscriptionModel getStoreSubscription(Long storeId) {
        SubscriptionEntity entity = repository.findByStoreId(storeId).orElseThrow(()
                -> new ExceptionHandler("We could not find your subscription. You may not have one."));
        return modelMapper.entityToModel(entity);
    }
}
