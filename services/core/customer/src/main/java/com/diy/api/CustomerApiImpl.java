package com.diy.api;

import com.diy.generated.api.CustomerApi;
import com.diy.generated.model.CustomerDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerApiImpl implements CustomerApi {
    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(Long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteCustomersByStoresId(Long storeId) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDto> findCustomerById(Long customerId) {
        return null;
    }

    @Override
    public ResponseEntity<List<CustomerDto>> findCustomersByStoreId(Long storeId) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto) {
        return null;
    }
}
