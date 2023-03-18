package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.CustomisationDto;
import com.diy.mapper.CustomisationModelMapper;
import com.diy.model.CustomisationModel;
import com.diy.service.CustomisationService;

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

@ContextConfiguration(classes = {CustomisationApiImpl.class})
@ExtendWith(SpringExtension.class)
class CustomisationApiImplTest {
    @Autowired
    private CustomisationApiImpl customisationApiImpl;

    @MockBean
    private CustomisationModelMapper customisationModelMapper;

    @MockBean
    private CustomisationService customisationService;

    /**
     * Method under test: {@link CustomisationApiImpl#createCustomisation(CustomisationDto)}
     */
    @Test
    void testCreateCustomisation() {
        when(customisationService.createCustomisation((CustomisationModel) any())).thenReturn(new CustomisationModel());
        when(customisationModelMapper.modelToDto((CustomisationModel) any())).thenReturn(new CustomisationDto());
        when(customisationModelMapper.dtoToModel((CustomisationDto) any())).thenReturn(new CustomisationModel());
        CustomisationDto customisationDto = new CustomisationDto();
        ResponseEntity<CustomisationDto> actualCreateCustomisationResult = customisationApiImpl
                .createCustomisation(customisationDto);
        assertEquals(customisationDto, actualCreateCustomisationResult.getBody());
        assertTrue(actualCreateCustomisationResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualCreateCustomisationResult.getStatusCode());
        verify(customisationService).createCustomisation((CustomisationModel) any());
        verify(customisationModelMapper).modelToDto((CustomisationModel) any());
        verify(customisationModelMapper).dtoToModel((CustomisationDto) any());
    }

    /**
     * Method under test: {@link CustomisationApiImpl#deleteCustomisationById(Long)}
     */
    @Test
    void testDeleteCustomisationById() {
        when(customisationService.deleteCustomisationById((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteCustomisationByIdResult = customisationApiImpl.deleteCustomisationById(1L);
        assertEquals("42", actualDeleteCustomisationByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteCustomisationByIdResult.getStatusCode());
        assertTrue(actualDeleteCustomisationByIdResult.getHeaders().isEmpty());
        verify(customisationService).deleteCustomisationById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationApiImpl#findCustomisationById(Long)}
     */
    @Test
    void testFindCustomisationById() {
        when(customisationService.findCustomisationById((Long) any())).thenReturn(new CustomisationModel());
        when(customisationModelMapper.modelToDto((CustomisationModel) any())).thenReturn(new CustomisationDto());
        ResponseEntity<CustomisationDto> actualFindCustomisationByIdResult = customisationApiImpl
                .findCustomisationById(1L);
        assertTrue(actualFindCustomisationByIdResult.hasBody());
        assertTrue(actualFindCustomisationByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindCustomisationByIdResult.getStatusCode());
        verify(customisationService).findCustomisationById((Long) any());
        verify(customisationModelMapper).modelToDto((CustomisationModel) any());
    }

    /**
     * Method under test: {@link CustomisationApiImpl#findCustomisationByStoreId(Long)}
     */
    @Test
    void testFindCustomisationByStoreId() {
        ArrayList<CustomisationModel> customisationModelList = new ArrayList<>();
        when(customisationService.findCustomisationByStoreId((Long) any())).thenReturn(customisationModelList);
        when(customisationModelMapper.modelsToDtos((List<CustomisationModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<CustomisationDto>> actualFindCustomisationByStoreIdResult = customisationApiImpl
                .findCustomisationByStoreId(1L);
        assertEquals(customisationModelList, actualFindCustomisationByStoreIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindCustomisationByStoreIdResult.getStatusCode());
        assertTrue(actualFindCustomisationByStoreIdResult.getHeaders().isEmpty());
        verify(customisationService).findCustomisationByStoreId((Long) any());
        verify(customisationModelMapper).modelsToDtos((List<CustomisationModel>) any());
    }

    /**
     * Method under test: {@link CustomisationApiImpl#updateCustomisation(CustomisationDto)}
     */
    @Test
    void testUpdateCustomisation() {
        when(customisationService.updateCustomisation((CustomisationModel) any())).thenReturn(new CustomisationModel());
        when(customisationModelMapper.modelToDto((CustomisationModel) any())).thenReturn(new CustomisationDto());
        when(customisationModelMapper.dtoToModel((CustomisationDto) any())).thenReturn(new CustomisationModel());
        CustomisationDto customisationDto = new CustomisationDto();
        ResponseEntity<CustomisationDto> actualUpdateCustomisationResult = customisationApiImpl
                .updateCustomisation(customisationDto);
        assertEquals(customisationDto, actualUpdateCustomisationResult.getBody());
        assertTrue(actualUpdateCustomisationResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateCustomisationResult.getStatusCode());
        verify(customisationService).updateCustomisation((CustomisationModel) any());
        verify(customisationModelMapper).modelToDto((CustomisationModel) any());
        verify(customisationModelMapper).dtoToModel((CustomisationDto) any());
    }
}

