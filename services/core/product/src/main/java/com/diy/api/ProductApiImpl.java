package com.diy.api;


import com.diy.generated.api.ProductApi;
import com.diy.generated.model.CategoryWithProductDto;
import com.diy.generated.model.CategoryWithoutProductDto;
import com.diy.generated.model.PagerDto;
import com.diy.generated.model.ProductDto;
import com.diy.mapper.CategoryModelMapper;
import com.diy.mapper.ProductModelMapper;
import com.diy.model.CategoryModel;
import com.diy.model.ProductModel;
import com.diy.service.CategoryService;
import com.diy.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
    CategoryService categoryService;
    CategoryModelMapper categoryModelMapper;

    @Override
    public ResponseEntity<String> deleteProductById(Long productid) {
        return ResponseEntity.ok(productService.deleteProductById(productid));
    }

    @Override
    public ResponseEntity<ProductDto> findProductById(Long productid) {
        return ResponseEntity.ok(productModelMapper.toProductDto(productService.findProductById(productid)));
    }



    @Override
    public ResponseEntity<List<ProductDto>> getAllProductByStoreId(PagerDto pagerDto) {
        return ResponseEntity.ok(productModelMapper.modelsToProductDtos(productService.getAllProductByStoreId(pagerDto)));
    }

    @Override
    public ResponseEntity<ProductDto> saveProduct(ProductDto productDto) {
        ProductModel product = productModelMapper.dtoToModel(productDto);
        return ResponseEntity.ok(productModelMapper.toProductDto(productService.saveProduct(product)));
    }

    @Override
    public ResponseEntity<CategoryWithoutProductDto> getAllCategoryByStoreId(PagerDto pagerDto) {
        return null;
    }

    @Override
    public ResponseEntity<CategoryWithProductDto> getCategoryAndItsProductByStoreId(Long categoryid, PagerDto pagerDto) {
        return null;
    }
}
