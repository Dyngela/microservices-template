package com.diy.api;

import com.diy.generated.api.SubscriptionApi;
import com.diy.generated.model.SaveSubscriptionDto;
import com.diy.generated.model.SubscriptionDto;
import com.diy.generated.model.SubscriptionTypeDto;
import com.diy.mapper.SubscriptionModelMapper;
import com.diy.mapper.SubscriptionTypeModelMapper;
import com.diy.service.SubscriptionService;
import com.diy.service.SubscriptionTypeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SubscriptionApiImpl implements SubscriptionApi {

    SubscriptionTypeModelMapper typeMapper;
    SubscriptionModelMapper mapper;
    SubscriptionTypeService typeService;
    SubscriptionService subscriptionService;

    @Override
    public ResponseEntity<String> createStoreSubscription(SaveSubscriptionDto saveSubscriptionDto) {
        return ResponseEntity.ok(subscriptionService.createSubscription(mapper.saveDtoToModel(saveSubscriptionDto)));
    }

    @Override
    public ResponseEntity<String> updateStoreSubscription(SaveSubscriptionDto saveSubscriptionDto) {
        return ResponseEntity.ok(subscriptionService.updateSubscription(mapper.saveDtoToModel(saveSubscriptionDto)));
    }

    @Override
    public ResponseEntity<List<SubscriptionTypeDto>> findAllSubscriptionType() {
        return ResponseEntity.ok(typeMapper.modelsToDtos(typeService.findAllSubscriptionType()));
    }

    @Override
    public ResponseEntity<SubscriptionDto> getStoreSubscription(Long storeId) {
        return ResponseEntity.ok(mapper.modelToDto(subscriptionService.getStoreSubscription(storeId)));
    }


}
