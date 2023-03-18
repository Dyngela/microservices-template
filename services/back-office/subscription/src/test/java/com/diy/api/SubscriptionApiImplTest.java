package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.SubscriptionDto;
import com.diy.generated.model.SubscriptionTypeDto;
import com.diy.mapper.SubscriptionModelMapper;
import com.diy.mapper.SubscriptionTypeModelMapper;
import com.diy.model.SubscriptionModel;
import com.diy.model.SubscriptionTypeModel;
import com.diy.service.SubscriptionService;
import com.diy.service.SubscriptionTypeService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubscriptionApiImpl.class})
@ExtendWith(SpringExtension.class)
class SubscriptionApiImplTest {
    @Autowired
    private SubscriptionApiImpl subscriptionApiImpl;

    @MockBean
    private SubscriptionModelMapper subscriptionModelMapper;

    @MockBean
    private SubscriptionService subscriptionService;

    @MockBean
    private SubscriptionTypeModelMapper subscriptionTypeModelMapper;

    @MockBean
    private SubscriptionTypeService subscriptionTypeService;

    /**
     * Method under test: {@link SubscriptionApiImpl#findAllSubscriptionType()}
     */
    @Test
    void testFindAllSubscriptionType() {
        when(subscriptionTypeModelMapper.modelsToDtos((List<SubscriptionTypeModel>) any())).thenReturn(new ArrayList<>());
        ArrayList<SubscriptionTypeModel> subscriptionTypeModelList = new ArrayList<>();
        when(subscriptionTypeService.findAllSubscriptionType()).thenReturn(subscriptionTypeModelList);
        ResponseEntity<List<SubscriptionTypeDto>> actualFindAllSubscriptionTypeResult = subscriptionApiImpl
                .findAllSubscriptionType();
        assertEquals(subscriptionTypeModelList, actualFindAllSubscriptionTypeResult.getBody());
        assertEquals(HttpStatus.OK, actualFindAllSubscriptionTypeResult.getStatusCode());
        assertTrue(actualFindAllSubscriptionTypeResult.getHeaders().isEmpty());
        verify(subscriptionTypeModelMapper).modelsToDtos((List<SubscriptionTypeModel>) any());
        verify(subscriptionTypeService).findAllSubscriptionType();
    }

    /**
     * Method under test: {@link SubscriptionApiImpl#getStoreSubscription(Long)}
     */
    @Test
    void testGetStoreSubscription() {
        when(subscriptionModelMapper.modelToDto((SubscriptionModel) any())).thenReturn(new SubscriptionDto());
        when(subscriptionService.getStoreSubscription((Long) any())).thenReturn(new SubscriptionModel());
        ResponseEntity<SubscriptionDto> actualStoreSubscription = subscriptionApiImpl.getStoreSubscription(1L);
        assertTrue(actualStoreSubscription.hasBody());
        assertTrue(actualStoreSubscription.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualStoreSubscription.getStatusCode());
        verify(subscriptionModelMapper).modelToDto((SubscriptionModel) any());
        verify(subscriptionService).getStoreSubscription((Long) any());
    }
}

