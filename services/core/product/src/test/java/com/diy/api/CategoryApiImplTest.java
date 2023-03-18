package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.CategoryWithProductDto;
import com.diy.generated.model.CategoryWithoutProductDto;
import com.diy.mapper.CategoryModelMapper;
import com.diy.model.CategoryModel;
import com.diy.service.CategoryService;

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

@ContextConfiguration(classes = {CategoryApiImpl.class})
@ExtendWith(SpringExtension.class)
class CategoryApiImplTest {
    @Autowired
    private CategoryApiImpl categoryApiImpl;

    @MockBean
    private CategoryModelMapper categoryModelMapper;

    @MockBean
    private CategoryService categoryService;

    /**
     * Method under test: {@link CategoryApiImpl#deleteCategoryById(Long)}
     */
    @Test
    void testDeleteCategoryById() {
        when(categoryService.deleteCategoryById((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteCategoryByIdResult = categoryApiImpl.deleteCategoryById(1L);
        assertEquals("42", actualDeleteCategoryByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteCategoryByIdResult.getStatusCode());
        assertTrue(actualDeleteCategoryByIdResult.getHeaders().isEmpty());
        verify(categoryService).deleteCategoryById((Long) any());
    }

    /**
     * Method under test: {@link CategoryApiImpl#getAllCategoryByStoreId(Long)}
     */
    @Test
    void testGetAllCategoryByStoreId() {
        ArrayList<CategoryModel> categoryModelList = new ArrayList<>();
        when(categoryService.getAllCategoryByStoreId((Long) any())).thenReturn(categoryModelList);
        when(categoryModelMapper.modelsToCategoryWoProductDtos((List<CategoryModel>) any()))
                .thenReturn(new ArrayList<>());
        ResponseEntity<List<CategoryWithoutProductDto>> actualAllCategoryByStoreId = categoryApiImpl
                .getAllCategoryByStoreId(1L);
        assertEquals(categoryModelList, actualAllCategoryByStoreId.getBody());
        assertEquals(HttpStatus.OK, actualAllCategoryByStoreId.getStatusCode());
        assertTrue(actualAllCategoryByStoreId.getHeaders().isEmpty());
        verify(categoryService).getAllCategoryByStoreId((Long) any());
        verify(categoryModelMapper).modelsToCategoryWoProductDtos((List<CategoryModel>) any());
    }

    /**
     * Method under test: {@link CategoryApiImpl#getCategoryAndItsProductByStoreId(Long)}
     */
    @Test
    void testGetCategoryAndItsProductByStoreId() {
        when(categoryService.getCategoryAndItsProductByStoreId((Long) any())).thenReturn(new CategoryModel());
        when(categoryModelMapper.modelToCategoryWPDto((CategoryModel) any())).thenReturn(new CategoryWithProductDto());
        ResponseEntity<CategoryWithProductDto> actualCategoryAndItsProductByStoreId = categoryApiImpl
                .getCategoryAndItsProductByStoreId(1L);
        assertTrue(actualCategoryAndItsProductByStoreId.hasBody());
        assertTrue(actualCategoryAndItsProductByStoreId.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualCategoryAndItsProductByStoreId.getStatusCode());
        verify(categoryService).getCategoryAndItsProductByStoreId((Long) any());
        verify(categoryModelMapper).modelToCategoryWPDto((CategoryModel) any());
    }
}

