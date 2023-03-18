package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.CategoryEntity;
import com.diy.entity.ProductEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.ProductModelMapper;
import com.diy.model.ProductModel;
import com.diy.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductService.class})
@ExtendWith(SpringExtension.class)
class ProductServiceTest {
    @MockBean
    private ProductModelMapper productModelMapper;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    /**
     * Method under test: {@link ProductService#deleteProductById(Long)}
     */
    @Test
    void testDeleteProductById() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        Optional<ProductEntity> ofResult = Optional.of(productEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setAvailableInStore(true);
        productEntity1.setCategory(categoryEntity1);
        productEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setDescription("The characteristics of someone or something");
        productEntity1.setHeight(10.0f);
        productEntity1.setName("Name");
        productEntity1.setPhoto("alice.liddell@example.org");
        productEntity1.setPrice(10.0f);
        productEntity1.setProductId(1L);
        productEntity1.setStoreId(1L);
        productEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setWeight(10.0f);
        when(productRepository.save((ProductEntity) any())).thenReturn(productEntity1);
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your product has been deleted", productService.deleteProductById(1L));
        verify(productRepository).save((ProductEntity) any());
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#deleteProductById(Long)}
     */
    @Test
    void testDeleteProductById2() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        Optional<ProductEntity> ofResult = Optional.of(productEntity);
        when(productRepository.save((ProductEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> productService.deleteProductById(1L));
        verify(productRepository).save((ProductEntity) any());
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#findProductById(Long)}
     */
    @Test
    void testFindProductById() {
        ProductModel productModel = new ProductModel();
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(productModel);

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        Optional<ProductEntity> ofResult = Optional.of(productEntity);
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(productModel, productService.findProductById(1L));
        verify(productModelMapper).entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any());
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#findProductById(Long)}
     */
    @Test
    void testFindProductById2() {
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        Optional<ProductEntity> ofResult = Optional.of(productEntity);
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> productService.findProductById(1L));
        verify(productModelMapper).entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any());
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#findProductById(Long)}
     */
    @Test
    void testFindProductById3() {
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ProductModel());
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> productService.findProductById(1L));
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#getAllProductByStoreId(Long)}
     */
    @Test
    void testGetAllProductByStoreId() {
        ArrayList<ProductModel> productModelList = new ArrayList<>();
        when(productModelMapper.entitiesToModels((List<ProductEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(productModelList);
        when(productRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        List<ProductModel> actualAllProductByStoreId = productService.getAllProductByStoreId(1L);
        assertSame(productModelList, actualAllProductByStoreId);
        assertTrue(actualAllProductByStoreId.isEmpty());
        verify(productModelMapper).entitiesToModels((List<ProductEntity>) any(), (CycleAvoidingMappingContext) any());
        verify(productRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#getAllProductByStoreId(Long)}
     */
    @Test
    void testGetAllProductByStoreId2() {
        when(productModelMapper.entitiesToModels((List<ProductEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ArrayList<>());
        when(productRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> productService.getAllProductByStoreId(1L));
        verify(productRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#createProduct(ProductModel)}
     */
    @Test
    void testCreateProduct() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        ProductModel productModel = new ProductModel();
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(productModel);
        when(productModelMapper.modelToEntity((ProductModel) any())).thenReturn(productEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setAvailableInStore(true);
        productEntity1.setCategory(categoryEntity1);
        productEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setDescription("The characteristics of someone or something");
        productEntity1.setHeight(10.0f);
        productEntity1.setName("Name");
        productEntity1.setPhoto("alice.liddell@example.org");
        productEntity1.setPrice(10.0f);
        productEntity1.setProductId(1L);
        productEntity1.setStoreId(1L);
        productEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setWeight(10.0f);
        when(productRepository.save((ProductEntity) any())).thenReturn(productEntity1);
        assertSame(productModel, productService.createProduct(new ProductModel()));
        verify(productModelMapper).modelToEntity((ProductModel) any());
        verify(productModelMapper).entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any());
        verify(productRepository).save((ProductEntity) any());
    }

    /**
     * Method under test: {@link ProductService#createProduct(ProductModel)}
     */
    @Test
    void testCreateProduct2() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ProductModel());
        when(productModelMapper.modelToEntity((ProductModel) any())).thenReturn(productEntity);
        when(productRepository.save((ProductEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> productService.createProduct(new ProductModel()));
        verify(productModelMapper).modelToEntity((ProductModel) any());
        verify(productRepository).save((ProductEntity) any());
    }

    /**
     * Method under test: {@link ProductService#updateProduct(ProductModel)}
     */
    @Test
    void testUpdateProduct() {
        ProductModel productModel = new ProductModel();
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(productModel);
        doNothing().when(productModelMapper)
                .updateStoreFromModel((ProductModel) any(), (ProductEntity) any(), (CycleAvoidingMappingContext) any());

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        Optional<ProductEntity> ofResult = Optional.of(productEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity1 = new ProductEntity();
        productEntity1.setAvailableInStore(true);
        productEntity1.setCategory(categoryEntity1);
        productEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setDescription("The characteristics of someone or something");
        productEntity1.setHeight(10.0f);
        productEntity1.setName("Name");
        productEntity1.setPhoto("alice.liddell@example.org");
        productEntity1.setPrice(10.0f);
        productEntity1.setProductId(1L);
        productEntity1.setStoreId(1L);
        productEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity1.setWeight(10.0f);
        when(productRepository.save((ProductEntity) any())).thenReturn(productEntity1);
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(productModel, productService.updateProduct(new ProductModel()));
        verify(productModelMapper).entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any());
        verify(productModelMapper).updateStoreFromModel((ProductModel) any(), (ProductEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(productRepository).save((ProductEntity) any());
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link ProductService#updateProduct(ProductModel)}
     */
    @Test
    void testUpdateProduct2() {
        when(productModelMapper.entityToModel((ProductEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ProductModel());
        doNothing().when(productModelMapper)
                .updateStoreFromModel((ProductModel) any(), (ProductEntity) any(), (CycleAvoidingMappingContext) any());

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ProductEntity productEntity = new ProductEntity();
        productEntity.setAvailableInStore(true);
        productEntity.setCategory(categoryEntity);
        productEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setDescription("The characteristics of someone or something");
        productEntity.setHeight(10.0f);
        productEntity.setName("Name");
        productEntity.setPhoto("alice.liddell@example.org");
        productEntity.setPrice(10.0f);
        productEntity.setProductId(1L);
        productEntity.setStoreId(1L);
        productEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        productEntity.setWeight(10.0f);
        Optional<ProductEntity> ofResult = Optional.of(productEntity);
        when(productRepository.save((ProductEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(productRepository.findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> productService.updateProduct(new ProductModel()));
        verify(productModelMapper).updateStoreFromModel((ProductModel) any(), (ProductEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(productRepository).save((ProductEntity) any());
        verify(productRepository).findByProductIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }
}

