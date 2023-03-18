package com.diy.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.generated.model.TicketDto;
import com.diy.mapper.TicketModelMapper;
import com.diy.model.TicketModel;
import com.diy.service.TicketService;

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

@ContextConfiguration(classes = {TicketApiImpl.class})
@ExtendWith(SpringExtension.class)
class TicketApiImplTest {
    @Autowired
    private TicketApiImpl ticketApiImpl;

    @MockBean
    private TicketModelMapper ticketModelMapper;

    @MockBean
    private TicketService ticketService;

    /**
     * Method under test: {@link TicketApiImpl#findCustomersTicketByStoreId(Long)}
     */
    @Test
    void testFindCustomersTicketByStoreId() {
        ArrayList<TicketModel> ticketModelList = new ArrayList<>();
        when(ticketService.findCustomersTicketByStoreId((Long) any())).thenReturn(ticketModelList);
        when(ticketModelMapper.modelsToDtos((List<TicketModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<TicketDto>> actualFindCustomersTicketByStoreIdResult = ticketApiImpl
                .findCustomersTicketByStoreId(1L);
        assertEquals(ticketModelList, actualFindCustomersTicketByStoreIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindCustomersTicketByStoreIdResult.getStatusCode());
        assertTrue(actualFindCustomersTicketByStoreIdResult.getHeaders().isEmpty());
        verify(ticketService).findCustomersTicketByStoreId((Long) any());
        verify(ticketModelMapper).modelsToDtos((List<TicketModel>) any());
    }

    /**
     * Method under test: {@link TicketApiImpl#findStoreTicketByStoreId(Long)}
     */
    @Test
    void testFindStoreTicketByStoreId() {
        ArrayList<TicketModel> ticketModelList = new ArrayList<>();
        when(ticketService.findStoreTicketByStoreId((Long) any())).thenReturn(ticketModelList);
        when(ticketModelMapper.modelsToDtos((List<TicketModel>) any())).thenReturn(new ArrayList<>());
        ResponseEntity<List<TicketDto>> actualFindStoreTicketByStoreIdResult = ticketApiImpl.findStoreTicketByStoreId(1L);
        assertEquals(ticketModelList, actualFindStoreTicketByStoreIdResult.getBody());
        assertEquals(HttpStatus.OK, actualFindStoreTicketByStoreIdResult.getStatusCode());
        assertTrue(actualFindStoreTicketByStoreIdResult.getHeaders().isEmpty());
        verify(ticketService).findStoreTicketByStoreId((Long) any());
        verify(ticketModelMapper).modelsToDtos((List<TicketModel>) any());
    }

    /**
     * Method under test: {@link TicketApiImpl#findTicketById(Long)}
     */
    @Test
    void testFindTicketById() {
        when(ticketService.findTicketById((Long) any())).thenReturn(new TicketModel());
        when(ticketModelMapper.modelToDto((TicketModel) any())).thenReturn(new TicketDto());
        ResponseEntity<TicketDto> actualFindTicketByIdResult = ticketApiImpl.findTicketById(1L);
        assertTrue(actualFindTicketByIdResult.hasBody());
        assertTrue(actualFindTicketByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindTicketByIdResult.getStatusCode());
        verify(ticketService).findTicketById((Long) any());
        verify(ticketModelMapper).modelToDto((TicketModel) any());
    }

    /**
     * Method under test: {@link TicketApiImpl#updateTicket(TicketDto)}
     */
    @Test
    void testUpdateTicket() {
        when(ticketService.updateTicket((TicketModel) any())).thenReturn(new TicketModel());
        when(ticketModelMapper.modelToDto((TicketModel) any())).thenReturn(new TicketDto());
        when(ticketModelMapper.dtoToModel((TicketDto) any())).thenReturn(new TicketModel());
        TicketDto ticketDto = new TicketDto();
        ResponseEntity<TicketDto> actualUpdateTicketResult = ticketApiImpl.updateTicket(ticketDto);
        assertEquals(ticketDto, actualUpdateTicketResult.getBody());
        assertTrue(actualUpdateTicketResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateTicketResult.getStatusCode());
        verify(ticketService).updateTicket((TicketModel) any());
        verify(ticketModelMapper).modelToDto((TicketModel) any());
        verify(ticketModelMapper).dtoToModel((TicketDto) any());
    }

    /**
     * Method under test: {@link TicketApiImpl#createTicket(TicketDto)}
     */
    @Test
    void testCreateTicket() {
        when(ticketService.createTicket((TicketModel) any())).thenReturn(new TicketModel());
        when(ticketModelMapper.modelToDto((TicketModel) any())).thenReturn(new TicketDto());
        when(ticketModelMapper.dtoToModel((TicketDto) any())).thenReturn(new TicketModel());
        TicketDto ticketDto = new TicketDto();
        ResponseEntity<TicketDto> actualCreateTicketResult = ticketApiImpl.createTicket(ticketDto);
        assertEquals(ticketDto, actualCreateTicketResult.getBody());
        assertTrue(actualCreateTicketResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualCreateTicketResult.getStatusCode());
        verify(ticketService).createTicket((TicketModel) any());
        verify(ticketModelMapper).modelToDto((TicketModel) any());
        verify(ticketModelMapper).dtoToModel((TicketDto) any());
    }
}

