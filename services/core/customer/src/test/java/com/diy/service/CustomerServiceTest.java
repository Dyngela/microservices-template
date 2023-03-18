package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.CustomerEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CustomerModelMapper;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.model.CustomerModel;
import com.diy.repository.CustomerRepository;

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

@ContextConfiguration(classes = {CustomerService.class})
@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
    @MockBean
    private CustomerModelMapper customerModelMapper;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    /**
     * Method under test: {@link CustomerService#deleteCustomerById(Long)}
     */
    @Test
    void testDeleteCustomerById() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setCustomerId(1L);
        customerEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setEmail("jane.doe@example.org");
        customerEntity1.setEthAddress("42 Main St");
        customerEntity1.setFirstName("Jane");
        customerEntity1.setLastName("Doe");
        customerEntity1.setPhoneNumber("6625550144");
        customerEntity1.setStoreId(1L);
        customerEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customerRepository.save((CustomerEntity) any())).thenReturn(customerEntity1);
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertEquals("Your account has been deleted", customerService.deleteCustomerById(1L));
        verify(customerRepository).save((CustomerEntity) any());
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomerById(Long)}
     */
    @Test
    void testDeleteCustomerById2() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);
        when(customerRepository.save((CustomerEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customerService.deleteCustomerById(1L));
        verify(customerRepository).save((CustomerEntity) any());
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomersByStoresId(Long)}
     */
    @Test
    void testDeleteCustomersByStoresId() {
        when(customerRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        assertEquals("All your customers accounts has been deleted", customerService.deleteCustomersByStoresId(1L));
        verify(customerRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomersByStoresId(Long)}
     */
    @Test
    void testDeleteCustomersByStoresId2() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<CustomerEntity> customerEntityList = new ArrayList<>();
        customerEntityList.add(customerEntity);

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setCustomerId(1L);
        customerEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setEmail("jane.doe@example.org");
        customerEntity1.setEthAddress("42 Main St");
        customerEntity1.setFirstName("Jane");
        customerEntity1.setLastName("Doe");
        customerEntity1.setPhoneNumber("6625550144");
        customerEntity1.setStoreId(1L);
        customerEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customerRepository.save((CustomerEntity) any())).thenReturn(customerEntity1);
        when(customerRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(customerEntityList);
        assertEquals("All your customers accounts has been deleted", customerService.deleteCustomersByStoresId(1L));
        verify(customerRepository).save((CustomerEntity) any());
        verify(customerRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#deleteCustomersByStoresId(Long)}
     */
    @Test
    void testDeleteCustomersByStoresId3() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setCustomerId(2L);
        customerEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setEmail("john.smith@example.org");
        customerEntity1.setEthAddress("17 High St");
        customerEntity1.setFirstName("John");
        customerEntity1.setLastName("Smith");
        customerEntity1.setPhoneNumber("8605550118");
        customerEntity1.setStoreId(2L);
        customerEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<CustomerEntity> customerEntityList = new ArrayList<>();
        customerEntityList.add(customerEntity1);
        customerEntityList.add(customerEntity);

        CustomerEntity customerEntity2 = new CustomerEntity();
        customerEntity2.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity2.setCustomerId(1L);
        customerEntity2.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity2.setEmail("jane.doe@example.org");
        customerEntity2.setEthAddress("42 Main St");
        customerEntity2.setFirstName("Jane");
        customerEntity2.setLastName("Doe");
        customerEntity2.setPhoneNumber("6625550144");
        customerEntity2.setStoreId(1L);
        customerEntity2.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customerRepository.save((CustomerEntity) any())).thenReturn(customerEntity2);
        when(customerRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(customerEntityList);
        assertEquals("All your customers accounts has been deleted", customerService.deleteCustomersByStoresId(1L));
        verify(customerRepository, atLeast(1)).save((CustomerEntity) any());
        verify(customerRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomerById(Long)}
     */
    @Test
    void testFindCustomerById() {
        CustomerModel customerModel = new CustomerModel();
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customerModel);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(customerModel, customerService.findCustomerById(1L));
        verify(customerModelMapper).entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomerById(Long)}
     */
    @Test
    void testFindCustomerById2() {
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customerService.findCustomerById(1L));
        verify(customerModelMapper).entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomerById(Long)}
     */
    @Test
    void testFindCustomerById3() {
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomerModel());
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> customerService.findCustomerById(1L));
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomersByStoreId(Long)}
     */
    @Test
    void testFindCustomersByStoreId() {
        ArrayList<CustomerModel> customerModelList = new ArrayList<>();
        when(customerModelMapper.entitiesToModels((List<CustomerEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customerModelList);
        when(customerRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenReturn(new ArrayList<>());
        List<CustomerModel> actualFindCustomersByStoreIdResult = customerService.findCustomersByStoreId(1L);
        assertSame(customerModelList, actualFindCustomersByStoreIdResult);
        assertTrue(actualFindCustomersByStoreIdResult.isEmpty());
        verify(customerModelMapper).entitiesToModels((List<CustomerEntity>) any(), (CycleAvoidingMappingContext) any());
        verify(customerRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomersByStoreId(Long)}
     */
    @Test
    void testFindCustomersByStoreId2() {
        when(customerModelMapper.entitiesToModels((List<CustomerEntity>) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new ArrayList<>());
        when(customerRepository.findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> customerService.findCustomersByStoreId(1L));
        verify(customerRepository).findByStoreIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#updateCustomer(CustomerModel)}
     */
    @Test
    void testUpdateCustomer() {
        CustomerModel customerModel = new CustomerModel();
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customerModel);
        doNothing().when(customerModelMapper)
                .updateCustomerFromModel((CustomerModel) any(), (CustomerEntity) any(), (CycleAvoidingMappingContext) any());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setCustomerId(1L);
        customerEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setEmail("jane.doe@example.org");
        customerEntity1.setEthAddress("42 Main St");
        customerEntity1.setFirstName("Jane");
        customerEntity1.setLastName("Doe");
        customerEntity1.setPhoneNumber("6625550144");
        customerEntity1.setStoreId(1L);
        customerEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customerRepository.save((CustomerEntity) any())).thenReturn(customerEntity1);
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(customerModel, customerService.updateCustomer(new CustomerModel()));
        verify(customerModelMapper).entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customerModelMapper).updateCustomerFromModel((CustomerModel) any(), (CustomerEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(customerRepository).save((CustomerEntity) any());
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#updateCustomer(CustomerModel)}
     */
    @Test
    void testUpdateCustomer2() {
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomerModel());
        doNothing().when(customerModelMapper)
                .updateCustomerFromModel((CustomerModel) any(), (CustomerEntity) any(), (CycleAvoidingMappingContext) any());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);
        when(customerRepository.save((CustomerEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(customerRepository.findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customerService.updateCustomer(new CustomerModel()));
        verify(customerModelMapper).updateCustomerFromModel((CustomerModel) any(), (CustomerEntity) any(),
                (CycleAvoidingMappingContext) any());
        verify(customerRepository).save((CustomerEntity) any());
        verify(customerRepository).findByCustomerIdAndDeletedAt((Long) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#createCustomer(CustomerModel)}
     */
    @Test
    void testCreateCustomer() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        CustomerModel customerModel = new CustomerModel();
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customerModel);
        when(customerModelMapper.modelToEntity((CustomerModel) any())).thenReturn(customerEntity);

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setCustomerId(1L);
        customerEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity1.setEmail("jane.doe@example.org");
        customerEntity1.setEthAddress("42 Main St");
        customerEntity1.setFirstName("Jane");
        customerEntity1.setLastName("Doe");
        customerEntity1.setPhoneNumber("6625550144");
        customerEntity1.setStoreId(1L);
        customerEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customerRepository.save((CustomerEntity) any())).thenReturn(customerEntity1);
        assertSame(customerModel, customerService.createCustomer(new CustomerModel()));
        verify(customerModelMapper).modelToEntity((CustomerModel) any());
        verify(customerModelMapper).entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customerRepository).save((CustomerEntity) any());
    }

    /**
     * Method under test: {@link CustomerService#createCustomer(CustomerModel)}
     */
    @Test
    void testCreateCustomer2() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomerModel());
        when(customerModelMapper.modelToEntity((CustomerModel) any())).thenReturn(customerEntity);
        when(customerRepository.save((CustomerEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> customerService.createCustomer(new CustomerModel()));
        verify(customerModelMapper).modelToEntity((CustomerModel) any());
        verify(customerRepository).save((CustomerEntity) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomerByEmail(String)}
     */
    @Test
    void testFindCustomerByEmail() {
        CustomerModel customerModel = new CustomerModel();
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(customerModel);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);
        when(customerRepository.findByEmailAndDeletedAt((String) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertSame(customerModel, customerService.findCustomerByEmail("jane.doe@example.org"));
        verify(customerModelMapper).entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customerRepository).findByEmailAndDeletedAt((String) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomerByEmail(String)}
     */
    @Test
    void testFindCustomerByEmail2() {
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setCustomerId(1L);
        customerEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        customerEntity.setEmail("jane.doe@example.org");
        customerEntity.setEthAddress("42 Main St");
        customerEntity.setFirstName("Jane");
        customerEntity.setLastName("Doe");
        customerEntity.setPhoneNumber("6625550144");
        customerEntity.setStoreId(1L);
        customerEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<CustomerEntity> ofResult = Optional.of(customerEntity);
        when(customerRepository.findByEmailAndDeletedAt((String) any(), (LocalDateTime) any())).thenReturn(ofResult);
        assertThrows(ExceptionHandler.class, () -> customerService.findCustomerByEmail("jane.doe@example.org"));
        verify(customerModelMapper).entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any());
        verify(customerRepository).findByEmailAndDeletedAt((String) any(), (LocalDateTime) any());
    }

    /**
     * Method under test: {@link CustomerService#findCustomerByEmail(String)}
     */
    @Test
    void testFindCustomerByEmail3() {
        when(customerModelMapper.entityToModel((CustomerEntity) any(), (CycleAvoidingMappingContext) any()))
                .thenReturn(new CustomerModel());
        when(customerRepository.findByEmailAndDeletedAt((String) any(), (LocalDateTime) any()))
                .thenReturn(Optional.empty());
        assertThrows(ExceptionHandler.class, () -> customerService.findCustomerByEmail("jane.doe@example.org"));
        verify(customerRepository).findByEmailAndDeletedAt((String) any(), (LocalDateTime) any());
    }
}

