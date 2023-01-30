package com.diy.mapper;


import com.diy.entity.SubscriptionTypeEntity;
import com.diy.generated.model.SubscriptionTypeDto;
import com.diy.model.SubscriptionTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SubscriptionTypeModelMapper {
    List<SubscriptionTypeModel> entitiesToModels(List<SubscriptionTypeEntity> entities);
    List<SubscriptionTypeDto> modelsToDtos(List<SubscriptionTypeModel> entities);
}
