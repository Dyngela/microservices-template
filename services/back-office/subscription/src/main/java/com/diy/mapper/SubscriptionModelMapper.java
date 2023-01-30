package com.diy.mapper;

import com.diy.entity.SubscriptionEntity;
import com.diy.generated.model.SaveSubscriptionDto;
import com.diy.generated.model.SubscriptionDto;
import com.diy.model.SubscriptionModel;
import org.mapstruct.*;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubscriptionModelMapper {

    SubscriptionModel saveDtoToModel(SaveSubscriptionDto dto);
    SubscriptionEntity modelToEntity(SubscriptionModel model);
    SubscriptionModel entityToModel(SubscriptionEntity entity);
    SubscriptionDto modelToDto(SubscriptionModel model);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromModel(SubscriptionModel model, @MappingTarget SubscriptionEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

}
