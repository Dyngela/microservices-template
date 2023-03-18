package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.AddressDto;
import com.diy.generated.model.StoreDto;
import com.diy.mapper.AddressModelMapper;
import com.diy.mapper.StoreModelMapper;
import com.diy.model.AddressModel;
import com.diy.model.StoreModel;
import com.diy.service.AddressService;
import com.diy.service.StoreService;

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

@ContextConfiguration(classes = {StoreApiImpl.class})
@ExtendWith(SpringExtension.class)
class StoreApiImplTest {
    @MockBean
    private AddressModelMapper addressModelMapper;

    @MockBean
    private AddressService addressService;

    @Autowired
    private StoreApiImpl storeApiImpl;

    @MockBean
    private StoreModelMapper storeModelMapper;

    @MockBean
    private StoreService storeService;

    /**
     * Method under test: {@link StoreApiImpl#deleteAddressById(Long)}
     */
    @Test
    void testDeleteAddressById() {
        when(addressService.deleteAddress((Long) any())).thenReturn("42 Main St");
        ResponseEntity<String> actualDeleteAddressByIdResult = storeApiImpl.deleteAddressById(1L);
        assertEquals("42 Main St", actualDeleteAddressByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteAddressByIdResult.getStatusCode());
        assertTrue(actualDeleteAddressByIdResult.getHeaders().isEmpty());
        verify(addressService).deleteAddress((Long) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#deleteStoreById(Long)}
     */
    @Test
    void testDeleteStoreById() {
        when(storeService.deleteStore((Long) any())).thenReturn("Delete Store");
        ResponseEntity<String> actualDeleteStoreByIdResult = storeApiImpl.deleteStoreById(1L);
        assertEquals("Delete Store", actualDeleteStoreByIdResult.getBody());
        assertEquals(HttpStatus.OK, actualDeleteStoreByIdResult.getStatusCode());
        assertTrue(actualDeleteStoreByIdResult.getHeaders().isEmpty());
        verify(storeService).deleteStore((Long) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#findAddressById(Long)}
     */
    @Test
    void testFindAddressById() {
        when(addressService.getAddressById((Long) any())).thenReturn(new AddressModel());
        when(addressModelMapper.modelToDto((AddressModel) any())).thenReturn(new AddressDto());
        ResponseEntity<AddressDto> actualFindAddressByIdResult = storeApiImpl.findAddressById(1L);
        assertTrue(actualFindAddressByIdResult.hasBody());
        assertTrue(actualFindAddressByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindAddressByIdResult.getStatusCode());
        verify(addressService).getAddressById((Long) any());
        verify(addressModelMapper).modelToDto((AddressModel) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#findAddressesByStoreId(Long)}
     */
    @Test
    void testFindAddressesByStoreId() {
        ArrayList<AddressModel> addressModelList = new ArrayList<>();
        when(addressService.getAddressesFromStoreId((Long) any())).thenReturn(addressModelList);
        when(addressModelMapper.modelsToDtos((List<AddressModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<AddressDto>> actualFindAddressesByStoreIdResult = storeApiImpl.findAddressesByStoreId(1L);
        assertEquals(addressModelList, actualFindAddressesByStoreIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindAddressesByStoreIdResult.getStatusCode());
        assertTrue(actualFindAddressesByStoreIdResult.getHeaders().isEmpty());
        verify(addressService).getAddressesFromStoreId((Long) any());
        verify(addressModelMapper).modelsToDtos((List<AddressModel>) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#findStoreByEmail(String)}
     */
    @Test
    void testFindStoreByEmail() {
        when(storeService.findStoreByEmail((String) any())).thenReturn(new StoreModel());
        when(storeModelMapper.modelToDto((StoreModel) any())).thenReturn(new StoreDto());
        ResponseEntity<StoreDto> actualFindStoreByEmailResult = storeApiImpl.findStoreByEmail("jane.doe@example.org");
        assertTrue(actualFindStoreByEmailResult.hasBody());
        assertTrue(actualFindStoreByEmailResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindStoreByEmailResult.getStatusCode());
        verify(storeService).findStoreByEmail((String) any());
        verify(storeModelMapper).modelToDto((StoreModel) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#findStoreById(Long)}
     */
    @Test
    void testFindStoreById() {
        when(storeService.findStoreById((Long) any())).thenReturn(new StoreModel());
        when(storeModelMapper.modelToDto((StoreModel) any())).thenReturn(new StoreDto());
        ResponseEntity<StoreDto> actualFindStoreByIdResult = storeApiImpl.findStoreById(1L);
        assertTrue(actualFindStoreByIdResult.hasBody());
        assertTrue(actualFindStoreByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindStoreByIdResult.getStatusCode());
        verify(storeService).findStoreById((Long) any());
        verify(storeModelMapper).modelToDto((StoreModel) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#findStoreByStoreName(String)}
     */
    @Test
    void testFindStoreByStoreName() {
        when(storeService.findStoreByStoreName((String) any())).thenReturn(new StoreModel());
        when(storeModelMapper.modelToDto((StoreModel) any())).thenReturn(new StoreDto());
        ResponseEntity<StoreDto> actualFindStoreByStoreNameResult = storeApiImpl.findStoreByStoreName("Storename");
        assertTrue(actualFindStoreByStoreNameResult.hasBody());
        assertTrue(actualFindStoreByStoreNameResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindStoreByStoreNameResult.getStatusCode());
        verify(storeService).findStoreByStoreName((String) any());
        verify(storeModelMapper).modelToDto((StoreModel) any());
    }

    /**
     * Method under test: {@link StoreApiImpl#findStores()}
     */
    @Test
    void testFindStores() {
        ArrayList<StoreModel> storeModelList = new ArrayList<>();
        when(storeService.findAllStores()).thenReturn(storeModelList);
        when(storeModelMapper.modelsToDtos((List<StoreModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<StoreDto>> actualFindStoresResult = storeApiImpl.findStores();
        assertEquals(storeModelList, actualFindStoresResult.getBody());
        assertEquals(HttpStatus.OK, actualFindStoresResult.getStatusCode());
        assertTrue(actualFindStoresResult.getHeaders().isEmpty());
        verify(storeService).findAllStores();
        verify(storeModelMapper).modelsToDtos((List<StoreModel>) any());
    }
}

