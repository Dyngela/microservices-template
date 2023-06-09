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

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Method under test: {@link ProductApiImpl#deleteProductById(Long)}
     */
    @Test
    void testDeleteProductById() {
        when(productService.deleteProductById((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteProductByIdResult = productApiImpl.deleteProductById(1L);
        assertEquals("42", actualDeleteProductByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteProductByIdResult.getStatusCode());
        assertTrue(actualDeleteProductByIdResult.getHeaders().isEmpty());
        verify(productService).deleteProductById((Long) any());
    }

    /**
     * Method under test: {@link ProductApiImpl#findProductById(Long)}
     */
    @Test
    void testFindProductById() {
        when(productService.findProductById((Long) any())).thenReturn(new ProductModel());
        when(productModelMapper.toProductWOCategoryDto((ProductModel) any())).thenReturn(new ProductWithoutCategoryDto());
        ResponseEntity<ProductWithoutCategoryDto> actualFindProductByIdResult = productApiImpl.findProductById(1L);
        assertTrue(actualFindProductByIdResult.hasBody());
        assertTrue(actualFindProductByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindProductByIdResult.getStatusCode());
        verify(productService).findProductById((Long) any());
        verify(productModelMapper).toProductWOCategoryDto((ProductModel) any());
    }

    /**
     * Method under test: {@link ProductApiImpl#getAllProductByStoreId(Long)}
     */
    @Test
    void testGetAllProductByStoreId() {
        ArrayList<ProductModel> productModelList = new ArrayList<>();
        when(productService.getAllProductByStoreId((Long) any())).thenReturn(productModelList);
        when(productModelMapper.modelsToProductDtos((List<ProductModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<ProductDto>> actualAllProductByStoreId = productApiImpl.getAllProductByStoreId(1L);
        assertEquals(productModelList, actualAllProductByStoreId.getBody());
        assertEquals(HttpStatus.OK, actualAllProductByStoreId.getStatusCode());
        assertTrue(actualAllProductByStoreId.getHeaders().isEmpty());
        verify(productService).getAllProductByStoreId((Long) any());
        verify(productModelMapper).modelsToProductDtos((List<ProductModel>) any());
    }

    /**
     * Method under test: {@link ProductApiImpl#updateProduct(ProductDto)}
     */
    @Test
    void testUpdateProduct() {
        when(productService.updateProduct((ProductModel) any())).thenReturn(new ProductModel());
        when(productModelMapper.toProductWOCategoryDto((ProductModel) any())).thenReturn(new ProductWithoutCategoryDto());
        when(productModelMapper.dtoToModel((ProductDto) any())).thenReturn(new ProductModel());
        ResponseEntity<ProductWithoutCategoryDto> actualUpdateProductResult = productApiImpl
                .updateProduct(new ProductDto());
        assertTrue(actualUpdateProductResult.hasBody());
        assertTrue(actualUpdateProductResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateProductResult.getStatusCode());
        verify(productService).updateProduct((ProductModel) any());
        verify(productModelMapper).toProductWOCategoryDto((ProductModel) any());
        verify(productModelMapper).dtoToModel((ProductDto) any());
    }
}

