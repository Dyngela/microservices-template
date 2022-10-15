package com.diy.mapper;

import com.diy.entity.StoreEntity;
import com.diy.generated.model.StoreDto;
import com.diy.model.StoreModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        typeConversionPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface StoreModelMapper {
    StoreDto modelToDto(StoreModel storeModel);
    List<StoreDto> modelsToDtos(List<StoreModel> storeModels);

    StoreModel dtoToModel(StoreDto storeDto);
    List<StoreModel> dtosToModels(List<StoreDto> storeDtos);

    StoreEntity modelToEntity(StoreModel storeModel);
    List<StoreEntity> modelsToEntities(List<StoreEntity> storeEntities);
    StoreModel entityToModel(StoreEntity storeEntity);
    List<StoreModel> entitiesToModels(List<StoreEntity> storeEntities);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateStoreFromModel(StoreModel model, @MappingTarget StoreEntity entity);
}
