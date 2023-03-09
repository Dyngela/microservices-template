package com.diy.client.store;

import com.diy.generated.model.StoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "STORE/api/v1/store")
//@FeignClient(value = "localhost:8001/api/v1/store")
public interface StoreClient {
    @PutMapping("/save")
    StoreDto createStore(StoreDto store);
}
