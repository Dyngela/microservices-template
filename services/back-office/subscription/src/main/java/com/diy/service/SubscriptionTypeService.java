package com.diy.service;

import com.diy.entity.SubscriptionTypeEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.SubscriptionModelMapper;
import com.diy.mapper.SubscriptionTypeModelMapper;
import com.diy.model.SubscriptionTypeModel;
import com.diy.repository.SubcriptionTypeRepository;
import com.diy.repository.SubscriptionRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class SubscriptionTypeService {

    SubcriptionTypeRepository repository;
    SubscriptionTypeModelMapper modelMapper;

    public List<SubscriptionTypeModel> findAllSubscriptionType() {
        try {
            List<SubscriptionTypeEntity> entities = repository.findAllByDeletedAt(null);
            return modelMapper.entitiesToModels(entities);
        } catch (Exception e) {
            log.error("Error while finding all subs type : " +  e.getMessage());
            throw new ExceptionHandler("We could not find subscription type, retry later please");
        }

    }

}
