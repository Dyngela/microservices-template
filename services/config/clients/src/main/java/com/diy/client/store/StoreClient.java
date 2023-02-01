package com.diy.client.store;

import com.diy.generated.model.StoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(value = "localhost:8001/api/v1/store")
public interface StoreClient {
    @PutMapping("/save")
    StoreDto createStore(StoreDto store);

//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "/all",
//            produces = { "application/json" }
//    )
//    List<StoreDto> getAllStore();
}
