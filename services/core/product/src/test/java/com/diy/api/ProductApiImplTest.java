package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.ProductDto;
import com.diy.generated.model.ProductWithoutCategoryDto;
import com.diy.mapper.ProductModelMapper;
import com.diy.model.ProductModel;
import com.diy.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductApiImpl.class})
@ExtendWith(SpringExtension.class)
class ProductApiImplTest {
    @Autowired
    private ProductApiImpl productApiImpl;

    @MockBean
    private ProductModelMapper productModelMapper;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link ProductApiImpl#createProduct(ProductDto)}
     */
    @Test
    void testCreateProduct() {
        when(productService.createProduct((ProductModel) any())).thenReturn(new ProductModel());
        when(productModelMapper.toProductWOCategoryDto((ProductModel) any())).thenReturn(new ProductWithoutCategoryDto());
        when(productModelMapper.dtoToModel((ProductDto) any())).thenReturn(new ProductModel());
        ResponseEntity<ProductWithoutCategoryDto> actualCreateProductResult = productApiImpl
                .createProduct(new ProductDto());
        assertTrue(actualCreateProductResult.hasBody());
        assertTrue(actualCreateProductResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualCreateProductResult.getStatusCode());
        verify(productService).createProduct((ProductModel) any());
        verify(productModelMapper).toProductWOCategoryDto((ProductModel) any());
        verify(productModelMapper).dtoToModel((ProductDto) any());
    }
}

