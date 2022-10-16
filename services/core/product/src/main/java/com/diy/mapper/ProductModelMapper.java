package com.diy.mapper;

import com.diy.generated.model.ProductDto;
import com.diy.model.ProductModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        typeConversionPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ProductModelMapper {
    ProductDto toDto(ProductModel productModel);
}
