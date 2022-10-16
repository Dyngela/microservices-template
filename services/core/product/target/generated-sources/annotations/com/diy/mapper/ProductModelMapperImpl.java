package com.diy.mapper;

import com.diy.generated.model.ProductDto;
import com.diy.model.ProductModel;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-16T12:18:33+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (OpenJDK Porters Group)"
)
@Component
public class ProductModelMapperImpl implements ProductModelMapper {

    @Override
    public ProductDto toDto(ProductModel productModel) {
        if ( productModel == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( productModel.getProductId() );
        productDto.setName( productModel.getName() );
        if ( productModel.getPrice() != null ) {
            productDto.setPrice( BigDecimal.valueOf( productModel.getPrice() ) );
        }
        productDto.setDescription( productModel.getDescription() );
        if ( productModel.getWeight() != null ) {
            productDto.setWeight( BigDecimal.valueOf( productModel.getWeight() ) );
        }
        if ( productModel.getHeight() != null ) {
            productDto.setHeight( BigDecimal.valueOf( productModel.getHeight() ) );
        }
        productDto.setPhoto( productModel.getPhoto() );
        productDto.setAvailableInStore( productModel.getAvailableInStore() );
        productDto.setStoreId( productModel.getStoreId() );

        return productDto;
    }
}
