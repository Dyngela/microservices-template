package com.diy.api;

import com.diy.generated.api.CustomerApi;
import com.diy.generated.model.CustomerDto;
import com.diy.mapper.CustomerModelMapper;
import com.diy.service.CustomerService;
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

    CustomerService customerService;
    CustomerModelMapper modelMapper;
    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        return ResponseEntity.ok(
                modelMapper.modelToDto(
                        customerService.createCustomer(
                                modelMapper.dtoToModel(customerDto))));
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(Long customerId) {
        return ResponseEntity.ok(customerService.deleteCustomerById(customerId));
    }

    @Override
    public ResponseEntity<String> deleteCustomersByStoresId(Long storeId) {
        return ResponseEntity.ok(customerService.deleteCustomersByStoresId(storeId));
    }

    @Override
    public ResponseEntity<CustomerDto> findCustomerById(Long customerId) {
        return ResponseEntity.ok(modelMapper.modelToDto(customerService.findCustomerById(customerId)));
    }

    @Override
    public ResponseEntity<List<CustomerDto>> findCustomersByStoreId(Long storeId) {
        return ResponseEntity.ok(modelMapper.modelsToDtos(customerService.findCustomersByStoreId(storeId)));
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto) {
        return ResponseEntity.ok(modelMapper.modelToDto(customerService.updateCustomer(modelMapper.dtoToModel(customerDto))));
    }

}
