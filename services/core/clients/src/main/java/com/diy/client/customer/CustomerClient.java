package com.diy.client.customer;


import com.diy.generated.model.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(value = "CUSTOMER/api/v1/customer")
public interface CustomerClient {
    @PutMapping("/save")
    CustomerDto createCustomer(CustomerDto store);
}

