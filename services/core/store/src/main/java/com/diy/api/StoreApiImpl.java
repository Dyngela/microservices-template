package com.diy.api;

import com.diy.generated.api.StoreApi;
import com.diy.generated.model.StoreDto;
import com.diy.mapper.StoreModelMapper;
import com.diy.model.StoreModel;
import com.diy.repository.StoreRepository;
import com.diy.service.StoreService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StoreApiImpl implements StoreApi {

    StoreService storeService;
    StoreModelMapper storeModelMapper;

    @Override
    public ResponseEntity<StoreDto> findStoreById(Long storeId) {

        return ResponseEntity.ok(storeModelMapper.modelToDto(storeService.findStoreById(storeId)));
    }

    @Override
    public ResponseEntity<List<StoreDto>> findStores(Integer size, Integer page, String sortBy, Boolean ascending) {
        return ResponseEntity.ok(storeModelMapper.modelsToDtos(storeService.findAllStores(size, page, sortBy, ascending)));
    }

    @Override
    public ResponseEntity<StoreDto> saveStore(StoreDto storeDto) {
        StoreModel store = storeModelMapper.dtoToModel(storeDto);
        return ResponseEntity.ok(storeModelMapper.modelToDto(storeService.save(store)));
    }

    @Override
    public ResponseEntity<String> deleteStoreById(Long storeId) {
        return ResponseEntity.ok(storeService.deleteStore(storeId));
    }


}
