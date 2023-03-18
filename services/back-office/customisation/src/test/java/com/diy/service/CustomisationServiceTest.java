package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.CustomisationEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CustomisationModelMapper;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.model.CustomisationModel;
import com.diy.repository.CustomisationRepository;

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

@ContextConfiguration(classes = {CustomisationService.class})
@ExtendWith(SpringExtension.class)
class CustomisationServiceTest {
    @MockBean
    private CustomisationModelMapper customisationModelMapper;

    @MockBean
    private CustomisationRepository customisationRepository;

    @Autowired
    private CustomisationService customisationService;

    /**
     * Method under test: {@link CustomisationService#createCustomisation(CustomisationModel)}
     */
    @Test
    void testCreateCustomisation() {
        assertThrows(ExceptionHandler.class, () -> customisationService.createCustomisation(new CustomisationModel()));
    }

    /**
     * Method under test: {@link CustomisationService#createCustomisation(CustomisationModel)}
     */
    @Test
    void testCreateCustomisation2() {
        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        CustomisationModel customisationModel = new CustomisationModel();
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customisationModel);
        when(customisationModelMapper.modelToEntity((CustomisationModel) any())).thenReturn(customisationEntity);

        CustomisationEntity customisationEntity1 = new CustomisationEntity();
        customisationEntity1.setActive(true);
        customisationEntity1.setCatchPhrase("Catch Phrase");
        customisationEntity1.setColorBackground("Color Background");
        customisationEntity1.setColorButton("Color Button");
        customisationEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setCustomisationId(1L);
        customisationEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setFont("Font");
        customisationEntity1.setStoreId(1L);
        customisationEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customisationRepository.save((CustomisationEntity) any())).thenReturn(customisationEntity1);
        when(customisationRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        when(customisationRepository.saveAll((Iterable<CustomisationEntity>) any())).thenReturn(new ArrayList<>());

        CustomisationModel customisationModel1 = new CustomisationModel();
        customisationModel1.setActive(true);
        assertSame(customisationModel, customisationService.createCustomisation(customisationModel1));
        verify(customisationModelMapper).modelToEntity((CustomisationModel) any());
        verify(customisationModelMapper).entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customisationRepository).save((CustomisationEntity) any());
        verify(customisationRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(customisationRepository).saveAll((Iterable<CustomisationEntity>) any());
    }

    /**
     * Method under test: {@link CustomisationService#createCustomisation(CustomisationModel)}
     */
    @Test
    void testCreateCustomisation3() {
        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomisationModel());
        when(customisationModelMapper.modelToEntity((CustomisationModel) any())).thenReturn(customisationEntity);
        when(customisationRepository.save((CustomisationEntity) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(customisationRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(customisationRepository.saveAll((Iterable<CustomisationEntity>) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        CustomisationModel customisationModel = new CustomisationModel();
        customisationModel.setActive(true);
        assertThrows(ExceptionHandler.class, () -> customisationService.createCustomisation(customisationModel));
        verify(customisationRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomisationService#createCustomisation(CustomisationModel)}
     */
    @Test
    void testCreateCustomisation4() {
        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        CustomisationModel customisationModel = new CustomisationModel();
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customisationModel);
        when(customisationModelMapper.modelToEntity((CustomisationModel) any())).thenReturn(customisationEntity);

        CustomisationEntity customisationEntity1 = new CustomisationEntity();
        customisationEntity1.setActive(true);
        customisationEntity1.setCatchPhrase("Catch Phrase");
        customisationEntity1.setColorBackground("Color Background");
        customisationEntity1.setColorButton("Color Button");
        customisationEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setCustomisationId(1L);
        customisationEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setFont("Font");
        customisationEntity1.setStoreId(1L);
        customisationEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        CustomisationEntity customisationEntity2 = new CustomisationEntity();
        customisationEntity2.setActive(true);
        customisationEntity2.setCatchPhrase("Catch Phrase");
        customisationEntity2.setColorBackground("Color Background");
        customisationEntity2.setColorButton("Color Button");
        customisationEntity2.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity2.setCustomisationId(1L);
        customisationEntity2.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity2.setFont("Font");
        customisationEntity2.setStoreId(1L);
        customisationEntity2.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<CustomisationEntity> customisationEntityList = new ArrayList<>();
        customisationEntityList.add(customisationEntity2);
        when(customisationRepository.save((CustomisationEntity) any())).thenReturn(customisationEntity1);
        when(customisationRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(customisationEntityList);
        when(customisationRepository.saveAll((Iterable<CustomisationEntity>) any())).thenReturn(new ArrayList<>());

        CustomisationModel customisationModel1 = new CustomisationModel();
        customisationModel1.setActive(true);
        assertSame(customisationModel, customisationService.createCustomisation(customisationModel1));
        verify(customisationModelMapper).modelToEntity((CustomisationModel) any());
        verify(customisationModelMapper).entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customisationRepository).save((CustomisationEntity) any());
        verify(customisationRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(customisationRepository).saveAll((Iterable<CustomisationEntity>) any());
    }

    /**
     * Method under test: {@link CustomisationService#deleteCustomisationById(Long)}
     */
    @Test
    void testDeleteCustomisationById() {
        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customisationService.deleteCustomisationById(1L));
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#deleteCustomisationById(Long)}
     */
    @Test
    void testDeleteCustomisationById2() {
        CustomisationEntity customisationEntity = mock(CustomisationEntity.class);
        when(customisationEntity.getActive()).thenReturn(false);
        doNothing().when(customisationEntity).setActive((Boolean) any());
        doNothing().when(customisationEntity).setCatchPhrase((String) any());
        doNothing().when(customisationEntity).setColorBackground((String) any());
        doNothing().when(customisationEntity).setColorButton((String) any());
        doNothing().when(customisationEntity).setCreatedAt((LocalDateTime) any());
        doNothing().when(customisationEntity).setCustomisationId((Long) any());
        doNothing().when(customisationEntity).setDeletedAt((LocalDateTime) any());
        doNothing().when(customisationEntity).setFont((String) any());
        doNothing().when(customisationEntity).setStoreId((Long) any());
        doNothing().when(customisationEntity).setUpdatedAt((LocalDateTime) any());
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);

        CustomisationEntity customisationEntity1 = new CustomisationEntity();
        customisationEntity1.setActive(true);
        customisationEntity1.setCatchPhrase("Catch Phrase");
        customisationEntity1.setColorBackground("Color Background");
        customisationEntity1.setColorButton("Color Button");
        customisationEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setCustomisationId(1L);
        customisationEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setFont("Font");
        customisationEntity1.setStoreId(1L);
        customisationEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customisationRepository.save((CustomisationEntity) any())).thenReturn(customisationEntity1);
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);
        assertEquals("Your theme has been successfully deleted", customisationService.deleteCustomisationById(1L));
        verify(customisationRepository).save((CustomisationEntity) any());
        verify(customisationRepository).findById((Long) any());
        verify(customisationEntity).getActive();
        verify(customisationEntity).setActive((Boolean) any());
        verify(customisationEntity).setCatchPhrase((String) any());
        verify(customisationEntity).setColorBackground((String) any());
        verify(customisationEntity).setColorButton((String) any());
        verify(customisationEntity).setCreatedAt((LocalDateTime) any());
        verify(customisationEntity).setCustomisationId((Long) any());
        verify(customisationEntity, atLeast(1)).setDeletedAt((LocalDateTime) any());
        verify(customisationEntity).setFont((String) any());
        verify(customisationEntity).setStoreId((Long) any());
        verify(customisationEntity, atLeast(1)).setUpdatedAt((LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomisationService#deleteCustomisationById(Long)}
     */
    @Test
    void testDeleteCustomisationById3() {
        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customisationRepository.save((CustomisationEntity) any())).thenReturn(customisationEntity);
        when(customisationRepository.findById((Long) any())).thenReturn(Optional.empty());
        CustomisationEntity customisationEntity1 = mock(CustomisationEntity.class);
        when(customisationEntity1.getActive()).thenReturn(true);
        doNothing().when(customisationEntity1).setActive((Boolean) any());
        doNothing().when(customisationEntity1).setCatchPhrase((String) any());
        doNothing().when(customisationEntity1).setColorBackground((String) any());
        doNothing().when(customisationEntity1).setColorButton((String) any());
        doNothing().when(customisationEntity1).setCreatedAt((LocalDateTime) any());
        doNothing().when(customisationEntity1).setCustomisationId((Long) any());
        doNothing().when(customisationEntity1).setDeletedAt((LocalDateTime) any());
        doNothing().when(customisationEntity1).setFont((String) any());
        doNothing().when(customisationEntity1).setStoreId((Long) any());
        doNothing().when(customisationEntity1).setUpdatedAt((LocalDateTime) any());
        customisationEntity1.setActive(true);
        customisationEntity1.setCatchPhrase("Catch Phrase");
        customisationEntity1.setColorBackground("Color Background");
        customisationEntity1.setColorButton("Color Button");
        customisationEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setCustomisationId(1L);
        customisationEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setFont("Font");
        customisationEntity1.setStoreId(1L);
        customisationEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        assertThrows(ExceptionHandler.class, () -> customisationService.deleteCustomisationById(1L));
        verify(customisationRepository).findById((Long) any());
        verify(customisationEntity1).setActive((Boolean) any());
        verify(customisationEntity1).setCatchPhrase((String) any());
        verify(customisationEntity1).setColorBackground((String) any());
        verify(customisationEntity1).setColorButton((String) any());
        verify(customisationEntity1).setCreatedAt((LocalDateTime) any());
        verify(customisationEntity1).setCustomisationId((Long) any());
        verify(customisationEntity1).setDeletedAt((LocalDateTime) any());
        verify(customisationEntity1).setFont((String) any());
        verify(customisationEntity1).setStoreId((Long) any());
        verify(customisationEntity1).setUpdatedAt((LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomisationService#findCustomisationById(Long)}
     */
    @Test
    void testFindCustomisationById() {
        CustomisationModel customisationModel = new CustomisationModel();
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customisationModel);

        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(customisationModel, customisationService.findCustomisationById(1L));
        verify(customisationModelMapper).entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#findCustomisationById(Long)}
     */
    @Test
    void testFindCustomisationById2() {
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customisationService.findCustomisationById(1L));
        verify(customisationModelMapper).entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#findCustomisationById(Long)}
     */
    @Test
    void testFindCustomisationById3() {
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomisationModel());
        when(customisationRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> customisationService.findCustomisationById(1L));
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#findCustomisationByStoreId(Long)}
     */
    @Test
    void testFindCustomisationByStoreId() {
        ArrayList<CustomisationModel> customisationModelList = new ArrayList<>();
        when(customisationModelMapper.entitiesToModels((List<CustomisationEntity>) any(),
                (CycleAvoidingMappingContext) any())).thenReturn(customisationModelList);
        when(customisationRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        List<CustomisationModel> actualFindCustomisationByStoreIdResult = customisationService
                .findCustomisationByStoreId(1L);
        assertSame(customisationModelList, actualFindCustomisationByStoreIdResult);
        assertTrue(actualFindCustomisationByStoreIdResult.isEmpty());
        verify(customisationModelMapper).entitiesToModels((List<CustomisationEntity>) any(),
                (CycleAvoidingMappingContext) any());
        verify(customisationRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomisationService#findCustomisationByStoreId(Long)}
     */
    @Test
    void testFindCustomisationByStoreId2() {
        when(customisationModelMapper.entitiesToModels((List<CustomisationEntity>) any(),
                (CycleAvoidingMappingContext) any())).thenReturn(new ArrayList<>());
        when(customisationRepository.findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> customisationService.findCustomisationByStoreId(1L));
        verify(customisationRepository).findAllByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomisationService#updateCustomisation(CustomisationModel)}
     */
    @Test
    void testUpdateCustomisation() {
        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customisationService.updateCustomisation(new CustomisationModel()));
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#updateCustomisation(CustomisationModel)}
     */
    @Test
    void testUpdateCustomisation2() {
        when(customisationRepository.findById((Long) any())).thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> customisationService.updateCustomisation(new CustomisationModel()));
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#updateCustomisation(CustomisationModel)}
     */
    @Test
    void testUpdateCustomisation3() {
        CustomisationModel customisationModel = new CustomisationModel();
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customisationModel);
        doNothing().when(customisationModelMapper)
                .updateStoreFromModel((CustomisationModel) any(), (CustomisationEntity) any(),
                        (CycleAvoidingMappingContext) any());

        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);

        CustomisationEntity customisationEntity1 = new CustomisationEntity();
        customisationEntity1.setActive(true);
        customisationEntity1.setCatchPhrase("Catch Phrase");
        customisationEntity1.setColorBackground("Color Background");
        customisationEntity1.setColorButton("Color Button");
        customisationEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setCustomisationId(1L);
        customisationEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity1.setFont("Font");
        customisationEntity1.setStoreId(1L);
        customisationEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customisationRepository.save((CustomisationEntity) any())).thenReturn(customisationEntity1);
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);

        CustomisationModel customisationModel1 = new CustomisationModel();
        customisationModel1.setActive(true);
        assertSame(customisationModel, customisationService.updateCustomisation(customisationModel1));
        verify(customisationModelMapper).entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customisationModelMapper).updateStoreFromModel((CustomisationModel) any(), (CustomisationEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(customisationRepository).save((CustomisationEntity) any());
        verify(customisationRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link CustomisationService#updateCustomisation(CustomisationModel)}
     */
    @Test
    void testUpdateCustomisation4() {
        when(customisationModelMapper.entityToModel((CustomisationEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomisationModel());
        doNothing().when(customisationModelMapper)
                .updateStoreFromModel((CustomisationModel) any(), (CustomisationEntity) any(),
                        (CycleAvoidingMappingContext) any());

        CustomisationEntity customisationEntity = new CustomisationEntity();
        customisationEntity.setActive(true);
        customisationEntity.setCatchPhrase("Catch Phrase");
        customisationEntity.setColorBackground("Color Background");
        customisationEntity.setColorButton("Color Button");
        customisationEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setCustomisationId(1L);
        customisationEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customisationEntity.setFont("Font");
        customisationEntity.setStoreId(1L);
        customisationEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomisationEntity> ofResult = Optional.of(customisationEntity);
        when(customisationRepository.save((CustomisationEntity) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(customisationRepository.findById((Long) any())).thenReturn(ofResult);

        CustomisationModel customisationModel = new CustomisationModel();
        customisationModel.setActive(true);
        assertThrows(ExceptionHandler.class, () -> customisationService.updateCustomisation(customisationModel));
        verify(customisationModelMapper).updateStoreFromModel((CustomisationModel) any(), (CustomisationEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(customisationRepository).save((CustomisationEntity) any());
        verify(customisationRepository).findById((Long) any());
    }
}

