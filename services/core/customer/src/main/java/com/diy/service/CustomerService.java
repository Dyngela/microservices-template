package com.diy.service;

import com.diy.generated.model.CustomerDto;
import com.diy.mapper.CustomerModelMapper;
import com.diy.model.CustomerModel;
import com.diy.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class CustomerService {

    CustomerModelMapper modelMapper;
    CustomerRepository customerRepository;

    public CustomerModel createCustomer(CustomerDto customerDto) {
        return null;
    }

    public String deleteCustomerById(Long customerId) {
        return null;
    }

    public String deleteCustomersByStoresId(Long storeId) {
        return null;
    }

    public CustomerModel findCustomerById(Long customerId) {
        return null;
    }

    public List<CustomerModel> findCustomersByStoreId(Long storeId) {
        return null;
    }

    public CustomerModel updateCustomer(CustomerDto customerDto) {
        return null;
    }
    
}
