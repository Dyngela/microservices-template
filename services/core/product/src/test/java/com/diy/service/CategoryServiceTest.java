package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.CategoryEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CategoryModelMapper;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.model.CategoryModel;
import com.diy.repository.CategoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryService.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceTest {
    @MockBean
    private CategoryModelMapper categoryModelMapper;

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    /**
     * Method under test: {@link CategoryService#getAllCategoryByStoreId(Long)}
     */
    @Test
    void testGetAllCategoryByStoreId() {
        when(categoryRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<CategoryModel> categoryModelList = new ArrayList<>();
        when(categoryModelMapper.entitiesToModels((List<CategoryEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(categoryModelList);
        List<CategoryModel> actualAllCategoryByStoreId = categoryService.getAllCategoryByStoreId(1L);
        assertSame(categoryModelList, actualAllCategoryByStoreId);
        assertTrue(actualAllCategoryByStoreId.isEmpty());
        verify(categoryRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).entitiesToModels((List<CategoryEntity>) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#getAllCategoryByStoreId(Long)}
     */
    @Test
    void testGetAllCategoryByStoreId2() {
        when(categoryRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        when(categoryModelMapper.entitiesToModels((List<CategoryEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> categoryService.getAllCategoryByStoreId(1L));
        verify(categoryRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).entitiesToModels((List<CategoryEntity>) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#getCategoryAndItsProductByStoreId(Long)}
     */
    @Test
    void testGetCategoryAndItsProductByStoreId() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        CategoryModel categoryModel = new CategoryModel();
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(categoryModel);
        assertSame(categoryModel, categoryService.getCategoryAndItsProductByStoreId(1L));
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#getCategoryAndItsProductByStoreId(Long)}
     */
    @Test
    void testGetCategoryAndItsProductByStoreId2() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> categoryService.getCategoryAndItsProductByStoreId(1L));
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#getCategoryAndItsProductByStoreId(Long)}
     */
    @Test
    void testGetCategoryAndItsProductByStoreId3() {
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(Optional.empty());
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CategoryModel());
        assertThrows(ExceptionHandler.class, () -> categoryService.getCategoryAndItsProductByStoreId(1L));
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CategoryService#createCategory(CategoryModel)}
     */
    @Test
    void testCreateCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        CategoryModel categoryModel = new CategoryModel();
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(categoryModel);
        when(categoryModelMapper.modelToEntity((CategoryModel) any())).thenReturn(categoryEntity1);
        assertSame(categoryModel, categoryService.createCategory(new CategoryModel()));
        verify(categoryRepository).save((CategoryEntity) any());
        verify(categoryModelMapper).modelToEntity((CategoryModel) any());
        verify(categoryModelMapper).entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#createCategory(CategoryModel)}
     */
    @Test
    void testCreateCategory2() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(categoryModelMapper.modelToEntity((CategoryModel) any())).thenReturn(categoryEntity1);
        assertThrows(ExceptionHandler.class, () -> categoryService.createCategory(new CategoryModel()));
        verify(categoryRepository).save((CategoryEntity) any());
        verify(categoryModelMapper).modelToEntity((CategoryModel) any());
        verify(categoryModelMapper).entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#updateCategory(CategoryModel)}
     */
    @Test
    void testUpdateCategory() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity1);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        CategoryModel categoryModel = new CategoryModel();
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(categoryModel);
        doNothing().when(categoryModelMapper)
                .updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(), (CycleAvoidingMappingContext) any());
        assertSame(categoryModel, categoryService.updateCategory(new CategoryModel()));
        verify(categoryRepository).save((CategoryEntity) any());
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any());
        verify(categoryModelMapper).updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#updateCategory(CategoryModel)}
     */
    @Test
    void testUpdateCategory2() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity1);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        doThrow(new ExceptionHandler("An error occurred")).when(categoryModelMapper)
                .updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(), (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> categoryService.updateCategory(new CategoryModel()));
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link CategoryService#updateCategory(CategoryModel)}
     */
    @Test
    void testUpdateCategory3() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(Optional.empty());
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CategoryModel());
        doNothing().when(categoryModelMapper)
                .updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(), (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> categoryService.updateCategory(new CategoryModel()));
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }



    /**
     * Method under test: {@link CategoryService#updateCategory(CategoryModel)}
     */
    @Test
    void testUpdateCategory5() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity1);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        CategoryModel categoryModel = new CategoryModel();
        when(categoryModelMapper.entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(categoryModel);
        doNothing().when(categoryModelMapper)
                .updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(), (CycleAvoidingMappingContext) any());
        CategoryModel categoryModel1 = mock(CategoryModel.class);
        when(categoryModel1.getCategoryId()).thenReturn(1L);
        assertSame(categoryModel, categoryService.updateCategory(categoryModel1));
        verify(categoryRepository).save((CategoryEntity) any());
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(categoryModelMapper).entityToModel((CategoryEntity) any(), (CycleAvoidingMappingContext) any());
        verify(categoryModelMapper).updateCategoryFromModel((CategoryModel) any(), (CategoryEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(categoryModel1).getCategoryId();
    }

    /**
     * Method under test: {@link CategoryService#deleteCategoryById(Long)}
     */
    @Test
    void testDeleteCategoryById() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);

        CategoryEntity categoryEntity1 = new CategoryEntity();
        categoryEntity1.setCategoryId(1L);
        categoryEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity1.setName("Name");
        categoryEntity1.setProducts(new ArrayList<>());
        categoryEntity1.setStoreId(1L);
        categoryEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity1);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your category has been deleted", categoryService.deleteCategoryById(1L));
        verify(categoryRepository).save((CategoryEntity) any());
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CategoryService#deleteCategoryById(Long)}
     */
    @Test
    void testDeleteCategoryById2() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CategoryEntity> ofResult = Optional.of(categoryEntity);
        when(categoryRepository.save((CategoryEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> categoryService.deleteCategoryById(1L));
        verify(categoryRepository).save((CategoryEntity) any());
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CategoryService#deleteCategoryById(Long)}
     */
    @Test
    void testDeleteCategoryById3() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(1L);
        categoryEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        categoryEntity.setName("Name");
        categoryEntity.setProducts(new ArrayList<>());
        categoryEntity.setStoreId(1L);
        categoryEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(categoryRepository.save((CategoryEntity) any())).thenReturn(categoryEntity);
        when(categoryRepository.findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> categoryService.deleteCategoryById(1L));
        verify(categoryRepository).findByCategoryIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }
}

