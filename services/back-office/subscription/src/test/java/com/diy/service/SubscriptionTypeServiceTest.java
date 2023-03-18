package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.SubscriptionTypeEntity;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.SubscriptionTypeModelMapper;
import com.diy.model.SubscriptionTypeModel;
import com.diy.repository.SubcriptionTypeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubscriptionTypeService.class})
@ExtendWith(SpringExtension.class)
class SubscriptionTypeServiceTest {
    @MockBean
    private SubcriptionTypeRepository subcriptionTypeRepository;

    @MockBean
    private SubscriptionTypeModelMapper subscriptionTypeModelMapper;

    @Autowired
    private SubscriptionTypeService subscriptionTypeService;

    /**
     * Method under test: {@link SubscriptionTypeService#findAllSubscriptionType()}
     */
    @Test
    void testFindAllSubscriptionType() {
        when(subcriptionTypeRepository.findAllByDeletedAt((LocalDateTime) any())).thenReturn(new ArrayList<>());
        ArrayList<SubscriptionTypeModel> subscriptionTypeModelList = new ArrayList<>();
        when(subscriptionTypeModelMapper.entitiesToModels((List<SubscriptionTypeEntity>) any()))
                .thenReturn(subscriptionTypeModelList);
        List<SubscriptionTypeModel> actualFindAllSubscriptionTypeResult = subscriptionTypeService.findAllSubscriptionType();
        assertSame(subscriptionTypeModelList, actualFindAllSubscriptionTypeResult);
        assertTrue(actualFindAllSubscriptionTypeResult.isEmpty());
        verify(subcriptionTypeRepository).findAllByDeletedAt((LocalDateTime) any());
        verify(subscriptionTypeModelMapper).entitiesToModels((List<SubscriptionTypeEntity>) any());
    }

    /**
     * Method under test: {@link SubscriptionTypeService#findAllSubscriptionType()}
     */
    @Test
    void testFindAllSubscriptionType2() {
        when(subcriptionTypeRepository.findAllByDeletedAt((LocalDateTime) any())).thenReturn(new ArrayList<>());
        when(subscriptionTypeModelMapper.entitiesToModels((List<SubscriptionTypeEntity>) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> subscriptionTypeService.findAllSubscriptionType());
        verify(subcriptionTypeRepository).findAllByDeletedAt((LocalDateTime) any());
        verify(subscriptionTypeModelMapper).entitiesToModels((List<SubscriptionTypeEntity>) any());
    }

    /**
     * Method under test: {@link SubscriptionTypeService#findAllSubscriptionType()}
     */
    @Test
    void testFindAllSubscriptionType3() {
        SubscriptionTypeEntity subscriptionTypeEntity = new SubscriptionTypeEntity();
        subscriptionTypeEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        subscriptionTypeEntity.setName("We could not find subscription type, retry later please");
        subscriptionTypeEntity.setPrice(0.5f);
        subscriptionTypeEntity.setSubscriptionTypeId(2L);
        subscriptionTypeEntity.setSubscriptions(new ArrayList<>());
        subscriptionTypeEntity.setSupport("We could not find subscription type, retry later please");
        subscriptionTypeEntity.setTurnover(0.5d);
        subscriptionTypeEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));

        ArrayList<SubscriptionTypeEntity> subscriptionTypeEntityList = new ArrayList<>();
        subscriptionTypeEntityList.add(subscriptionTypeEntity);
        when(subcriptionTypeRepository.findAllByDeletedAt((LocalDateTime) any())).thenReturn(subscriptionTypeEntityList);
        when(subscriptionTypeModelMapper.entitiesToModels((List<SubscriptionTypeEntity>) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> subscriptionTypeService.findAllSubscriptionType());
        verify(subcriptionTypeRepository).findAllByDeletedAt((LocalDateTime) any());
        verify(subscriptionTypeModelMapper).entitiesToModels((List<SubscriptionTypeEntity>) any());
    }
}

