package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.AddressEntity;
import com.diy.entity.StoreEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.AddressModelMapper;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.model.AddressModel;
import com.diy.repository.AddressRepository;
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

@ContextConfiguration(classes = {AddressService.class})
@ExtendWith(SpringExtension.class)
class AddressServiceTest {
    @MockBean
    private AddressModelMapper addressModelMapper;

    @MockBean
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @MockBean
    private StoreRepository storeRepository;

    /**
     * Method under test: {@link AddressService#getAddressesFromStoreId(Long)}
     */
    @Test
    void testGetAddressesFromStoreId() {
        when(addressRepository.findByStoreAndDeletedAt((StoreEntity) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());

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
        ArrayList<AddressModel> addressModelList = new ArrayList<>();
        when(addressModelMapper.entitiesToModels((List<AddressEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(addressModelList);
        List<AddressModel> actualAddressesFromStoreId = addressService.getAddressesFromStoreId(1L);
        assertSame(addressModelList, actualAddressesFromStoreId);
        assertTrue(actualAddressesFromStoreId.isEmpty());
        verify(addressRepository).findByStoreAndDeletedAt((StoreEntity) any(), (LocalDateTime) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).entitiesToModels((List<AddressEntity>) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#getAddressesFromStoreId(Long)}
     */
    @Test
    void testGetAddressesFromStoreId2() {
        when(addressRepository.findByStoreAndDeletedAt((StoreEntity) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());

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
        when(addressModelMapper.entitiesToModels((List<AddressEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> addressService.getAddressesFromStoreId(1L));
        verify(addressRepository).findByStoreAndDeletedAt((StoreEntity) any(), (LocalDateTime) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).entitiesToModels((List<AddressEntity>) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#getAddressesFromStoreId(Long)}
     */
    @Test
    void testGetAddressesFromStoreId3() {
        when(addressRepository.findByStoreAndDeletedAt((StoreEntity) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(Optional.empty());
        when(addressModelMapper.entitiesToModels((List<AddressEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ArrayList<>());
        assertThrows(ExceptionHandler.class, () -> addressService.getAddressesFromStoreId(1L));
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link AddressService#getAddressById(Long)}
     */
    @Test
    void testGetAddressById() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<AddressEntity> ofResult = Optional.of(addressEntity);
        when(addressRepository.findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        AddressModel addressModel = new AddressModel();
        when(addressModelMapper.entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(addressModel);
        assertSame(addressModel, addressService.getAddressById(1L));
        verify(addressRepository).findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#getAddressById(Long)}
     */
    @Test
    void testGetAddressById2() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<AddressEntity> ofResult = Optional.of(addressEntity);
        when(addressRepository.findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        when(addressModelMapper.entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> addressService.getAddressById(1L));
        verify(addressRepository).findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#deleteAddress(Long)}
     */
    @Test
    void testDeleteAddress() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<AddressEntity> ofResult = Optional.of(addressEntity);

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

        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setAddressId(1L);
        addressEntity1.setCity("Oxford");
        addressEntity1.setComplement("Complement");
        addressEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setPostalCode("Postal Code");
        addressEntity1.setStore(storeEntity1);
        addressEntity1.setStreetName("Street Name");
        addressEntity1.setStreetNumber("42");
        addressEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(addressRepository.save((AddressEntity) any())).thenReturn(addressEntity1);
        when(addressRepository.findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your address has been successfully deleted", addressService.deleteAddress(1L));
        verify(addressRepository).save((AddressEntity) any());
        verify(addressRepository).findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link AddressService#deleteAddress(Long)}
     */
    @Test
    void testDeleteAddress2() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<AddressEntity> ofResult = Optional.of(addressEntity);
        when(addressRepository.save((AddressEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(addressRepository.findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> addressService.deleteAddress(1L));
        verify(addressRepository).save((AddressEntity) any());
        verify(addressRepository).findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link AddressService#createAddress(AddressModel, Long)}
     */
    @Test
    void testCreateAddress() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(addressRepository.save((AddressEntity) any())).thenReturn(addressEntity);

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
        Optional<StoreEntity> ofResult = Optional.of(storeEntity1);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);

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

        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setAddressId(1L);
        addressEntity1.setCity("Oxford");
        addressEntity1.setComplement("Complement");
        addressEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setPostalCode("Postal Code");
        addressEntity1.setStore(storeEntity2);
        addressEntity1.setStreetName("Street Name");
        addressEntity1.setStreetNumber("42");
        addressEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        AddressModel addressModel = new AddressModel();
        when(addressModelMapper.entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(addressModel);
        when(addressModelMapper.modelToEntity((AddressModel) any())).thenReturn(addressEntity1);
        assertSame(addressModel, addressService.createAddress(new AddressModel(), 1L));
        verify(addressRepository).save((AddressEntity) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).modelToEntity((AddressModel) any());
        verify(addressModelMapper).entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#createAddress(AddressModel, Long)}
     */
    @Test
    void testCreateAddress2() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(addressRepository.save((AddressEntity) any())).thenReturn(addressEntity);

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
        Optional<StoreEntity> ofResult = Optional.of(storeEntity1);
        when(storeRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);

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

        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setAddressId(1L);
        addressEntity1.setCity("Oxford");
        addressEntity1.setComplement("Complement");
        addressEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setPostalCode("Postal Code");
        addressEntity1.setStore(storeEntity2);
        addressEntity1.setStreetName("Street Name");
        addressEntity1.setStreetNumber("42");
        addressEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(addressModelMapper.entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        when(addressModelMapper.modelToEntity((AddressModel) any())).thenReturn(addressEntity1);
        assertThrows(ExceptionHandler.class, () -> addressService.createAddress(new AddressModel(), 1L));
        verify(addressRepository).save((AddressEntity) any());
        verify(storeRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).modelToEntity((AddressModel) any());
        verify(addressModelMapper).entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#updateAddress(AddressModel)}
     */
    @Test
    void testUpdateAddress() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<AddressEntity> ofResult = Optional.of(addressEntity);

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

        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setAddressId(1L);
        addressEntity1.setCity("Oxford");
        addressEntity1.setComplement("Complement");
        addressEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setPostalCode("Postal Code");
        addressEntity1.setStore(storeEntity1);
        addressEntity1.setStreetName("Street Name");
        addressEntity1.setStreetNumber("42");
        addressEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(addressRepository.save((AddressEntity) any())).thenReturn(addressEntity1);
        when(addressRepository.findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        AddressModel addressModel = new AddressModel();
        when(addressModelMapper.entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(addressModel);
        doNothing().when(addressModelMapper)
                .updateStoreFromModel((AddressModel) any(), (AddressEntity) any(), (CycleAvoidingMappingContext) any());
        assertSame(addressModel, addressService.updateAddress(new AddressModel()));
        verify(addressRepository).save((AddressEntity) any());
        verify(addressRepository).findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any());
        verify(addressModelMapper).updateStoreFromModel((AddressModel) any(), (AddressEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link AddressService#updateAddress(AddressModel)}
     */
    @Test
    void testUpdateAddress2() {
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressId(1L);
        addressEntity.setCity("Oxford");
        addressEntity.setComplement("Complement");
        addressEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity.setPostalCode("Postal Code");
        addressEntity.setStore(storeEntity);
        addressEntity.setStreetName("Street Name");
        addressEntity.setStreetNumber("42");
        addressEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<AddressEntity> ofResult = Optional.of(addressEntity);

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

        AddressEntity addressEntity1 = new AddressEntity();
        addressEntity1.setAddressId(1L);
        addressEntity1.setCity("Oxford");
        addressEntity1.setComplement("Complement");
        addressEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        addressEntity1.setPostalCode("Postal Code");
        addressEntity1.setStore(storeEntity1);
        addressEntity1.setStreetName("Street Name");
        addressEntity1.setStreetNumber("42");
        addressEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(addressRepository.save((AddressEntity) any())).thenReturn(addressEntity1);
        when(addressRepository.findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        when(addressModelMapper.entityToModel((AddressEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        doThrow(new ExceptionHandler("An error occurred")).when(addressModelMapper)
                .updateStoreFromModel((AddressModel) any(), (AddressEntity) any(), (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> addressService.updateAddress(new AddressModel()));
        verify(addressRepository).findByAddressIdAndDeletedAt((Long) any(), (LocalDateTime) any());
        verify(addressModelMapper).updateStoreFromModel((AddressModel) any(), (AddressEntity) any(),
                (CycleAvoidingMappingContext) any());
    }
}

