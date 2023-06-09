package com.diy.service;

import com.diy.entity.StoreEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.StoreModelMapper;
import com.diy.model.StoreModel;
import com.diy.repository.StoreRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class StoreService {

    StoreModelMapper storeModelMapper;
    StoreRepository storeRepository;

    public StoreModel findStoreById(Long id) {
        try {
            StoreEntity storeEntity = storeRepository.findByStoreIdAndDeletedAt(id, null).orElseThrow(() -> new ExceptionHandler("Store not found"));
            return storeModelMapper.entityToModel(storeEntity, new CycleAvoidingMappingContext());
        }  catch (Exception e) {
            log.error("Error while finding your store: " + e.getMessage());
            throw new ExceptionHandler("We could not find your store");
        }
    }

    public StoreModel findStoreByStoreName(String name) {
        try {
            StoreEntity storeEntity = storeRepository.findByStoreNameAndDeletedAt(name, null).orElseThrow(() -> new ExceptionHandler("Store not found"));
            return storeModelMapper.entityToModel(storeEntity, new CycleAvoidingMappingContext());
        }  catch (Exception e) {
            log.error("Error while finding your store: " + e.getMessage());
            throw new ExceptionHandler("We could not find your store");
        }
    }

    public List<StoreModel> findAllStores() {
        List<StoreEntity> storeEntities = storeRepository.findAllByDeletedAt(null);
        return storeModelMapper.entitiesToModels(storeEntities, new CycleAvoidingMappingContext());
    }

    public StoreModel updateStore(StoreModel storeModel) {
        try {
            StoreEntity storeEntity = storeRepository.findByStoreIdAndDeletedAt(storeModel.getStoreId(), null).orElseThrow(() -> new ExceptionHandler("Store not found"));
            storeModelMapper.updateStoreFromModel(storeModel, storeEntity, new CycleAvoidingMappingContext());
            storeEntity.setUpdatedAt(LocalDateTime.now());
            storeRepository.save(storeEntity);
            return storeModelMapper.entityToModel(storeEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while updating a store: " + e.getMessage());
            log.error("Store model: " + storeModel.toString());
            throw new ExceptionHandler("We could not update your information");
        }
    }

    public StoreModel createStore(StoreModel storeModel) {
        try {
            StoreEntity storeEntity = storeModelMapper.modelToEntity(storeModel);
            storeEntity.setCreatedAt(LocalDateTime.now());
            storeRepository.save(storeEntity);
            return storeModelMapper.entityToModel(storeEntity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while creating a store: " + e.getMessage());
            log.error("Store model: " + storeModel.toString());
            throw new ExceptionHandler("We could not create your store");
        }
    }

    public String deleteStore(Long storeId) {
        //TODO Delete its dependencies in other microservices
        try {
            StoreEntity storeEntity = storeRepository.findByStoreIdAndDeletedAt(storeId, null).orElseThrow(() -> new ExceptionHandler("Store not found"));
            storeEntity.setUpdatedAt(LocalDateTime.now());
            storeEntity.setDeletedAt(LocalDateTime.now());
            storeEntity.getAddresses().forEach(addressEntity -> {
                addressEntity.setDeletedAt(LocalDateTime.now());
                addressEntity.setUpdatedAt(LocalDateTime.now());
            });
            storeRepository.save(storeEntity);
            return "Your store has been successfully deleted";
        } catch (Exception e) {
            log.error("Error while deleting a store: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your store");
        }
    }

    public StoreModel findStoreByEmail(String email) {
        try {
            StoreEntity storeEntity = storeRepository.findByEmailAndDeletedAt(email, null).orElseThrow(() -> new ExceptionHandler("Store not found"));
            return storeModelMapper.entityToModel(storeEntity, new CycleAvoidingMappingContext());
        }  catch (Exception e) {
            log.error("Error while finding your store: " + e.getMessage());
            throw new ExceptionHandler("We could not find your store");
        }
    }
}
