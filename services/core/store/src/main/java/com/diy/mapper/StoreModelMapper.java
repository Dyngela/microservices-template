package com.diy.mapper;

import com.diy.model.StoreModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreModelMapper {
//    StoreDto toDto(StoreModel storeModel);
}
