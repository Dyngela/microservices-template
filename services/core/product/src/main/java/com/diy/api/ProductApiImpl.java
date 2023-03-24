package com.diy.api;


import com.diy.generated.api.ProductApi;
import com.diy.generated.model.ProductDto;
import com.diy.generated.model.ProductWithoutCategoryDto;
import com.diy.mapper.ProductModelMapper;
import com.diy.model.ProductModel;
import com.diy.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductApiImpl implements ProductApi {

    ProductService productService;
    ProductModelMapper productModelMapper;

    @Override
    public ResponseEntity<ProductWithoutCategoryDto> createProduct(ProductDto productDto) {
        ProductModel product = productModelMapper.dtoToModel(productDto);
        return ResponseEntity.ok(productModelMapper.toProductWOCategoryDto(productService.createProduct(product)));
    }

    @Override
    public ResponseEntity<String> deleteProductById(Long productId) {
        return ResponseEntity.ok(productService.deleteProductById(productId));
    }

    @Override
    public ResponseEntity<ProductWithoutCategoryDto> findProductById(Long productId) {
        return ResponseEntity.ok(productModelMapper.toProductWOCategoryDto(productService.findProductById(productId)));
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProductByStoreId(Long storeId) {
        return ResponseEntity.ok(productModelMapper.modelsToProductDtos(productService.getAllProductByStoreId(storeId)));
    }

    @Override
    public ResponseEntity<ProductWithoutCategoryDto> updateProduct(ProductDto productDto) {
        ProductModel product = productModelMapper.dtoToModel(productDto);
        return ResponseEntity.ok(productModelMapper.toProductWOCategoryDto(productService.updateProduct(product)));
    }

}
