package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.AddressEntity;
import com.diy.entity.StoreEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.StoreModelMapper;
import com.diy.model.StoreModel;
import com.diy.repository.StoreRepository;

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

@ContextConfiguration(classes = {StoreService.class})
@ExtendWith(SpringExtension.class)
class StoreServiceTest {
    @MockBean
    private StoreModelMapper storeModelMapper;

    @MockBean
    private StoreRepository storeRepository;

    @Autowired
    private StoreService storeService;

    /**
     * Method under test: {@link StoreService#findStoreById(Long)}
     */
    @Test
    void testFindStoreById() {
        StoreModel storeModel = new StoreModel();
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(storeModel);

        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(storeModel, storeService.findStoreById(1L));
        verify(storeModelMapper).entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findStoreById(Long)}
     */
    @Test
    void testFindStoreById2() {
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> storeService.findStoreById(1L));
        verify(storeModelMapper).entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findStoreById(Long)}
     */
    @Test
    void testFindStoreById3() {
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new StoreModel());
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> storeService.findStoreById(1L));
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findAllStores()}
     */
    @Test
    void testFindAllStores() {
        ArrayList<StoreModel> storeModelList = new ArrayList<>();
        when(storeModelMapper.entitiesToModels((List<StoreEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(storeModelList);
        when(storeRepository.findAllByDeletedAt((LocalDateTime) any())).thenReturn(new ArrayList<>());
        List<StoreModel> actualFindAllStoresResult = storeService.findAllStores();
        assertSame(storeModelList, actualFindAllStoresResult);
        assertTrue(actualFindAllStoresResult.isEmpty());
        verify(storeModelMapper).entitiesToModels((List<StoreEntity>) any(), (CycleAvoidingMappingContext) any());
        verify(storeRepository).findAllByDeletedAt((LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findAllStores()}
     */
    @Test
    void testFindAllStores2() {
        when(storeModelMapper.entitiesToModels((List<StoreEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ArrayList<>());
        when(storeRepository.findAllByDeletedAt((LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> storeService.findAllStores());
        verify(storeRepository).findAllByDeletedAt((LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#createStore(StoreModel)}
     */
    @Test
    void testCreateStore() {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        StoreModel storeModel = new StoreModel();
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(storeModel);
        when(storeModelMapper.modelToEntity((StoreModel) any())).thenReturn(storeEntity);

        StoreEntity storeEntity1 = new StoreEntity();
        storeEntity1.setAddresses(new ArrayList<>());
        storeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setEmail("jane.doe@example.org");
        storeEntity1.setEthAddress("42 Main St");
        storeEntity1.setFirstname("Jane");
        storeEntity1.setLastname("Doe");
        storeEntity1.setPhoneNumber("6625550144");
        storeEntity1.setSector("Sector");
        storeEntity1.setSiret("Siret");
        storeEntity1.setStoreId(1L);
        storeEntity1.setStoreName("Store Name");
        storeEntity1.setSubscriptionId(1L);
        storeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(storeRepository.save((StoreEntity) any())).thenReturn(storeEntity1);
        assertSame(storeModel, storeService.createStore(new StoreModel()));
        verify(storeModelMapper).modelToEntity((StoreModel) any());
        verify(storeModelMapper).entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any());
        verify(storeRepository).save((StoreEntity) any());
    }

    /**
     * Method under test: {@link StoreService#createStore(StoreModel)}
     */
    @Test
    void testCreateStore2() {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new StoreModel());
        when(storeModelMapper.modelToEntity((StoreModel) any())).thenReturn(storeEntity);
        when(storeRepository.save((StoreEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> storeService.createStore(new StoreModel()));
        verify(storeModelMapper).modelToEntity((StoreModel) any());
        verify(storeRepository).save((StoreEntity) any());
    }

    /**
     * Method under test: {@link StoreService#deleteStore(Long)}
     */
    @Test
    void testDeleteStore() {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity);

        StoreEntity storeEntity1 = new StoreEntity();
        storeEntity1.setAddresses(new ArrayList<>());
        storeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setEmail("jane.doe@example.org");
        storeEntity1.setEthAddress("42 Main St");
        storeEntity1.setFirstname("Jane");
        storeEntity1.setLastname("Doe");
        storeEntity1.setPhoneNumber("6625550144");
        storeEntity1.setSector("Sector");
        storeEntity1.setSiret("Siret");
        storeEntity1.setStoreId(1L);
        storeEntity1.setStoreName("Store Name");
        storeEntity1.setSubscriptionId(1L);
        storeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(storeRepository.save((StoreEntity) any())).thenReturn(storeEntity1);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your store has been successfully deleted", storeService.deleteStore(1L));
        verify(storeRepository).save((StoreEntity) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#deleteStore(Long)}
     */
    @Test
    void testDeleteStore2() {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity);
        when(storeRepository.save((StoreEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> storeService.deleteStore(1L));
        verify(storeRepository).save((StoreEntity) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#deleteStore(Long)}
     */
    @Test
    void testDeleteStore3() {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Your store has been successfully deleted");
        storeEntity.setSiret("Your store has been successfully deleted");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Your store has been successfully deleted");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Your store has been successfully deleted");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Your store has been successfully deleted");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Your store has been successfully deleted");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<AddressEntity> addressEntityList = new ArrayList<>();
        addressEntityList.add(addressEntity);

        StoreEntity storeEntity1 = new StoreEntity();
        storeEntity1.setAddresses(addressEntityList);
        storeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setEmail("jane.doe@example.org");
        storeEntity1.setEthAddress("42 Main St");
        storeEntity1.setFirstname("Jane");
        storeEntity1.setLastname("Doe");
        storeEntity1.setPhoneNumber("6625550144");
        storeEntity1.setSector("Sector");
        storeEntity1.setSiret("Siret");
        storeEntity1.setStoreId(1L);
        storeEntity1.setStoreName("Store Name");
        storeEntity1.setSubscriptionId(1L);
        storeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity1);

        StoreEntity storeEntity2 = new StoreEntity();
        storeEntity2.setAddresses(new ArrayList<>());
        storeEntity2.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity2.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity2.setEmail("jane.doe@example.org");
        storeEntity2.setEthAddress("42 Main St");
        storeEntity2.setFirstname("Jane");
        storeEntity2.setLastname("Doe");
        storeEntity2.setPhoneNumber("6625550144");
        storeEntity2.setSector("Sector");
        storeEntity2.setSiret("Siret");
        storeEntity2.setStoreId(1L);
        storeEntity2.setStoreName("Store Name");
        storeEntity2.setSubscriptionId(1L);
        storeEntity2.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(storeRepository.save((StoreEntity) any())).thenReturn(storeEntity2);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your store has been successfully deleted", storeService.deleteStore(1L));
        verify(storeRepository).save((StoreEntity) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#deleteStore(Long)}
     */
    @Test
    void testDeleteStore4() {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Your store has been successfully deleted");
        storeEntity.setSiret("Your store has been successfully deleted");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Your store has been successfully deleted");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Your store has been successfully deleted");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Your store has been successfully deleted");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Your store has been successfully deleted");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        StoreEntity storeEntity1 = new StoreEntity();
        storeEntity1.setAddresses(new ArrayList<>());
        storeEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity1.setEmail("john.smith@example.org");
        storeEntity1.setEthAddress("17 High St");
        storeEntity1.setFirstname("John");
        storeEntity1.setLastname("Smith");
        storeEntity1.setPhoneNumber("8605550118");
        storeEntity1.setSector("Sector");
        storeEntity1.setSiret("Siret");
        storeEntity1.setStoreId(2L);
        storeEntity1.setStoreName("Store Name");
        storeEntity1.setSubscriptionId(2L);
        storeEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setAddressId(2L);
        addressEntity1.setCity("London");
        addressEntity1.setComplement("Complement");
        addressEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setPostalCode("Postal Code");
        addressEntity1.setStore(storeEntity1);
        addressEntity1.setStreetName("Street Name");
        addressEntity1.setStreetNumber("Your store has been successfully deleted");
        addressEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<AddressEntity> addressEntityList = new ArrayList<>();
        addressEntityList.add(addressEntity1);
        addressEntityList.add(addressEntity);

        StoreEntity storeEntity2 = new StoreEntity();
        storeEntity2.setAddresses(addressEntityList);
        storeEntity2.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity2.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity2.setEmail("jane.doe@example.org");
        storeEntity2.setEthAddress("42 Main St");
        storeEntity2.setFirstname("Jane");
        storeEntity2.setLastname("Doe");
        storeEntity2.setPhoneNumber("6625550144");
        storeEntity2.setSector("Sector");
        storeEntity2.setSiret("Siret");
        storeEntity2.setStoreId(1L);
        storeEntity2.setStoreName("Store Name");
        storeEntity2.setSubscriptionId(1L);
        storeEntity2.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity2);

        StoreEntity storeEntity3 = new StoreEntity();
        storeEntity3.setAddresses(new ArrayList<>());
        storeEntity3.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity3.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity3.setEmail("jane.doe@example.org");
        storeEntity3.setEthAddress("42 Main St");
        storeEntity3.setFirstname("Jane");
        storeEntity3.setLastname("Doe");
        storeEntity3.setPhoneNumber("6625550144");
        storeEntity3.setSector("Sector");
        storeEntity3.setSiret("Siret");
        storeEntity3.setStoreId(1L);
        storeEntity3.setStoreName("Store Name");
        storeEntity3.setSubscriptionId(1L);
        storeEntity3.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(storeRepository.save((StoreEntity) any())).thenReturn(storeEntity3);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your store has been successfully deleted", storeService.deleteStore(1L));
        verify(storeRepository).save((StoreEntity) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findStoreByEmail(String)}
     */
    @Test
    void testFindStoreByEmail() {
        StoreModel storeModel = new StoreModel();
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(storeModel);

        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity);
        when(storeRepository.findByEmailAndDeletedAt((String) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(storeModel, storeService.findStoreByEmail("jane.doe@example.org"));
        verify(storeModelMapper).entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any());
        verify(storeRepository).findByEmailAndDeletedAt((String) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findStoreByEmail(String)}
     */
    @Test
    void testFindStoreByEmail2() {
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setAddresses(new ArrayList<>());
        storeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        storeEntity.setEmail("jane.doe@example.org");
        storeEntity.setEthAddress("42 Main St");
        storeEntity.setFirstname("Jane");
        storeEntity.setLastname("Doe");
        storeEntity.setPhoneNumber("6625550144");
        storeEntity.setSector("Sector");
        storeEntity.setSiret("Siret");
        storeEntity.setStoreId(1L);
        storeEntity.setStoreName("Store Name");
        storeEntity.setSubscriptionId(1L);
        storeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<StoreEntity> ofResult = Optional.of(storeEntity);
        when(storeRepository.findByEmailAndDeletedAt((String) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> storeService.findStoreByEmail("jane.doe@example.org"));
        verify(storeModelMapper).entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any());
        verify(storeRepository).findByEmailAndDeletedAt((String) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link StoreService#findStoreByEmail(String)}
     */
    @Test
    void testFindStoreByEmail3() {
        when(storeModelMapper.entityToModel((StoreEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new StoreModel());
        when(storeRepository.findByEmailAndDeletedAt((String) any(), (LocalDateTime) any())).thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> storeService.findStoreByEmail("jane.doe@example.org"));
        verify(storeRepository).findByEmailAndDeletedAt((String) any(), (LocalDateTime) any());
    }
}

