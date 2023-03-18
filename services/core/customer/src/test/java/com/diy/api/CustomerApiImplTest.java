package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.CustomerDto;
import com.diy.mapper.CustomerModelMapper;
import com.diy.model.CustomerModel;
import com.diy.service.CustomerService;

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

@ContextConfiguration(classes = {CustomerApiImpl.class})
@ExtendWith(SpringExtension.class)
class CustomerApiImplTest {
    @Autowired
    private CustomerApiImpl customerApiImpl;

    @MockBean
    private CustomerModelMapper customerModelMapper;

    @MockBean
    private CustomerService customerService;

    /**
     * Method under test: {@link CustomerApiImpl#deleteCustomerById(Long)}
     */
    @Test
    void testDeleteCustomerById() {
        when(customerService.deleteCustomerById((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteCustomerByIdResult = customerApiImpl.deleteCustomerById(1L);
        assertEquals("42", actualDeleteCustomerByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteCustomerByIdResult.getStatusCode());
        assertTrue(actualDeleteCustomerByIdResult.getHeaders().isEmpty());
        verify(customerService).deleteCustomerById((Long) any());
    }

    /**
     * Method under test: {@link CustomerApiImpl#deleteCustomersByStoresId(Long)}
     */
    @Test
    void testDeleteCustomersByStoresId() {
        when(customerService.deleteCustomersByStoresId((Long) any())).thenReturn("42");
        ResponseEntity<String> actualDeleteCustomersByStoresIdResult = customerApiImpl.deleteCustomersByStoresId(1L);
        assertEquals("42", actualDeleteCustomersByStoresIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteCustomersByStoresIdResult.getStatusCode());
        assertTrue(actualDeleteCustomersByStoresIdResult.getHeaders().isEmpty());
        verify(customerService).deleteCustomersByStoresId((Long) any());
    }

    /**
     * Method under test: {@link CustomerApiImpl#findCustomerByEmail(String)}
     */
    @Test
    void testFindCustomerByEmail() {
        when(customerService.findCustomerByEmail((String) any())).thenReturn(new CustomerModel());
        when(customerModelMapper.modelToDto((CustomerModel) any())).thenReturn(new CustomerDto());
        ResponseEntity<CustomerDto> actualFindCustomerByEmailResult = customerApiImpl
                .findCustomerByEmail("jane.doe@example.org");
        assertTrue(actualFindCustomerByEmailResult.hasBody());
        assertTrue(actualFindCustomerByEmailResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindCustomerByEmailResult.getStatusCode());
        verify(customerService).findCustomerByEmail((String) any());
        verify(customerModelMapper).modelToDto((CustomerModel) any());
    }

    /**
     * Method under test: {@link CustomerApiImpl#findCustomerById(Long)}
     */
    @Test
    void testFindCustomerById() {
        when(customerService.findCustomerById((Long) any())).thenReturn(new CustomerModel());
        when(customerModelMapper.modelToDto((CustomerModel) any())).thenReturn(new CustomerDto());
        ResponseEntity<CustomerDto> actualFindCustomerByIdResult = customerApiImpl.findCustomerById(1L);
        assertTrue(actualFindCustomerByIdResult.hasBody());
        assertTrue(actualFindCustomerByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindCustomerByIdResult.getStatusCode());
        verify(customerService).findCustomerById((Long) any());
        verify(customerModelMapper).modelToDto((CustomerModel) any());
    }

    /**
     * Method under test: {@link CustomerApiImpl#findCustomersByStoreId(Long)}
     */
    @Test
    void testFindCustomersByStoreId() {
        ArrayList<CustomerModel> customerModelList = new ArrayList<>();
        when(customerService.findCustomersByStoreId((Long) any())).thenReturn(customerModelList);
        when(customerModelMapper.modelsToDtos((List<CustomerModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<CustomerDto>> actualFindCustomersByStoreIdResult = customerApiImpl.findCustomersByStoreId(1L);
        assertEquals(customerModelList, actualFindCustomersByStoreIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindCustomersByStoreIdResult.getStatusCode());
        assertTrue(actualFindCustomersByStoreIdResult.getHeaders().isEmpty());
        verify(customerService).findCustomersByStoreId((Long) any());
        verify(customerModelMapper).modelsToDtos((List<CustomerModel>) any());
    }
}

