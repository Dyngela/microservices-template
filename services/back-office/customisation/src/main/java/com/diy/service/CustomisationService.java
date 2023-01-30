package com.diy.service;

import com.diy.entity.CustomisationEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CustomisationModelMapper;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.model.CustomisationModel;
import com.diy.repository.CustomisationRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class CustomisationService {

    CustomisationModelMapper modelMapper;
    CustomisationRepository customisationRepository;

    public CustomisationModel createCustomisation(CustomisationModel model) {
        try {
            CustomisationEntity entity = modelMapper.modelToEntity(model);
            entity.setCreatedAt(LocalDateTime.now());
            customisationRepository.save(entity);
            return modelMapper.entityToModel(entity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while creating a theme: " + e.getMessage());
            log.error("Customisation model: " + model.toString());
            throw new ExceptionHandler("We could not create your theme");
        }
    }

    public String deleteCustomisationById(Long customisationId) {
        try {
            CustomisationEntity entity = customisationRepository.findById(customisationId).orElseThrow(() -> new ExceptionHandler("Theme not found"));
            entity.setUpdatedAt(LocalDateTime.now());
            entity.setDeletedAt(LocalDateTime.now());
            customisationRepository.save(entity);
            return "Your theme has been successfully deleted";
        } catch (Exception e) {
            log.error("Error while deleting a theme: " + e.getMessage());
            throw new ExceptionHandler("We could not delete your theme");
        }
    }

    public CustomisationModel findCustomisationById(Long customisationId) {
        try {
            CustomisationEntity customisationEntity = customisationRepository.findById(customisationId).orElseThrow(() -> new ExceptionHandler("Theme not found"));
            return modelMapper.entityToModel(customisationEntity, new CycleAvoidingMappingContext());
        }  catch (Exception e) {
            log.error("Error while finding your store: " + e.getMessage());
            throw new ExceptionHandler("We could not find your store");
        }
    }

    public List<CustomisationModel> findCustomisationByStoreId(Long storeId) {
        try {
            List<CustomisationEntity> entites = customisationRepository.findAllByStoreIdAndDeletedAt(storeId, null);
            return modelMapper.entitiesToModels(entites, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while finding your list of theme: " + e.getMessage());
            throw new ExceptionHandler("We could not find your list of theme");
        }
    }

    public CustomisationModel updateCustomisation(CustomisationModel model) {
        try {

            CustomisationEntity entity = customisationRepository.findById(model.getCustomisationId()).orElseThrow(() -> new ExceptionHandler("Theme not found"));
            modelMapper.updateStoreFromModel(model, entity, new CycleAvoidingMappingContext());
            entity.setUpdatedAt(LocalDateTime.now());
            customisationRepository.save(entity);
            return modelMapper.entityToModel(entity, new CycleAvoidingMappingContext());
        } catch (Exception e) {
            log.error("Error while updating a theme: " + e.getMessage());
            log.error("Customisation model: " + model.toString());
            throw new ExceptionHandler("We could not update your theme");
        }
    }
}
