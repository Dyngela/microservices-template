package com.diy.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diy.entity.TicketEntity;
import com.diy.enums.ProblemType;
import com.diy.enums.SenderType;
import com.diy.enums.State;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.TicketModelMapper;
import com.diy.model.TicketModel;
import com.diy.repository.TicketRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TicketService.class})
@ExtendWith(SpringExtension.class)
class TicketServiceTest {
    @MockBean
    private TicketModelMapper ticketModelMapper;

    @MockBean
    private TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService;

    /**
     * Method under test: {@link TicketService#findCustomersTicketByStoreId(Long)}
     */
    @Test
    void testFindCustomersTicketByStoreId() {
        when(ticketRepository.findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any())).thenReturn(new ArrayList<>());
        ArrayList<TicketModel> ticketModelList = new ArrayList<>();
        when(ticketModelMapper.entitiesToModels((List<TicketEntity>) any())).thenReturn(ticketModelList);
        List<TicketModel> actualFindCustomersTicketByStoreIdResult = ticketService.findCustomersTicketByStoreId(1L);
        assertSame(ticketModelList, actualFindCustomersTicketByStoreIdResult);
        assertTrue(actualFindCustomersTicketByStoreIdResult.isEmpty());
        verify(ticketRepository).findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any());
        verify(ticketModelMapper).entitiesToModels((List<TicketEntity>) any());
    }

    /**
     * Method under test: {@link TicketService#findCustomersTicketByStoreId(Long)}
     */
    @Test
    void testFindCustomersTicketByStoreId2() {
        when(ticketRepository.findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any())).thenReturn(new ArrayList<>());
        when(ticketModelMapper.entitiesToModels((List<TicketEntity>) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> ticketService.findCustomersTicketByStoreId(1L));
        verify(ticketRepository).findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any());
        verify(ticketModelMapper).entitiesToModels((List<TicketEntity>) any());
    }

    /**
     * Method under test: {@link TicketService#findStoreTicketByStoreId(Long)}
     */
    @Test
    void testFindStoreTicketByStoreId() {
        when(ticketRepository.findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any())).thenReturn(new ArrayList<>());
        ArrayList<TicketModel> ticketModelList = new ArrayList<>();
        when(ticketModelMapper.entitiesToModels((List<TicketEntity>) any())).thenReturn(ticketModelList);
        List<TicketModel> actualFindStoreTicketByStoreIdResult = ticketService.findStoreTicketByStoreId(1L);
        assertSame(ticketModelList, actualFindStoreTicketByStoreIdResult);
        assertTrue(actualFindStoreTicketByStoreIdResult.isEmpty());
        verify(ticketRepository).findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any());
        verify(ticketModelMapper).entitiesToModels((List<TicketEntity>) any());
    }

    /**
     * Method under test: {@link TicketService#findStoreTicketByStoreId(Long)}
     */
    @Test
    void testFindStoreTicketByStoreId2() {
        when(ticketRepository.findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any())).thenReturn(new ArrayList<>());
        when(ticketModelMapper.entitiesToModels((List<TicketEntity>) any()))
                .thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> ticketService.findStoreTicketByStoreId(1L));
        verify(ticketRepository).findAllByStoreIdAndSenderTypeAndDeletedAt((Long) any(), (SenderType) any(),
                (LocalDateTime) any());
        verify(ticketModelMapper).entitiesToModels((List<TicketEntity>) any());
    }

    /**
     * Method under test: {@link TicketService#findTicketById(Long)}
     */
    @Test
    void testFindTicketById() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<TicketEntity> ofResult = Optional.of(ticketEntity);
        when(ticketRepository.findById((Long) any())).thenReturn(ofResult);
        TicketModel ticketModel = new TicketModel();
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenReturn(ticketModel);
        assertSame(ticketModel, ticketService.findTicketById(1L));
        verify(ticketRepository).findById((Long) any());
        verify(ticketModelMapper).entityToModel((TicketEntity) any());
    }

    /**
     * Method under test: {@link TicketService#findTicketById(Long)}
     */
    @Test
    void testFindTicketById2() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<TicketEntity> ofResult = Optional.of(ticketEntity);
        when(ticketRepository.findById((Long) any())).thenReturn(ofResult);
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        assertThrows(ExceptionHandler.class, () -> ticketService.findTicketById(1L));
        verify(ticketRepository).findById((Long) any());
        verify(ticketModelMapper).entityToModel((TicketEntity) any());
    }

    /**
     * Method under test: {@link TicketService#findTicketById(Long)}
     */
    @Test
    void testFindTicketById3() {
        when(ticketRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenReturn(new TicketModel());
        assertThrows(ExceptionHandler.class, () -> ticketService.findTicketById(1L));
        verify(ticketRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TicketService#updateTicket(TicketModel)}
     */
    @Test
    void testUpdateTicket() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<TicketEntity> ofResult = Optional.of(ticketEntity);
        when(ticketRepository.findById((Long) any())).thenReturn(ofResult);
        TicketModel ticketModel = new TicketModel();
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenReturn(ticketModel);
        doNothing().when(ticketModelMapper)
                .updateTicketFromModel((TicketModel) any(), (TicketEntity) any(), (CycleAvoidingMappingContext) any());
        assertSame(ticketModel, ticketService.updateTicket(new TicketModel()));
        verify(ticketRepository).findById((Long) any());
        verify(ticketModelMapper).entityToModel((TicketEntity) any());
        verify(ticketModelMapper).updateTicketFromModel((TicketModel) any(), (TicketEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link TicketService#updateTicket(TicketModel)}
     */
    @Test
    void testUpdateTicket2() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<TicketEntity> ofResult = Optional.of(ticketEntity);
        when(ticketRepository.findById((Long) any())).thenReturn(ofResult);
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        doThrow(new ExceptionHandler("An error occurred")).when(ticketModelMapper)
                .updateTicketFromModel((TicketModel) any(), (TicketEntity) any(), (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> ticketService.updateTicket(new TicketModel()));
        verify(ticketRepository).findById((Long) any());
        verify(ticketModelMapper).updateTicketFromModel((TicketModel) any(), (TicketEntity) any(),
                (CycleAvoidingMappingContext) any());
    }

    /**
     * Method under test: {@link TicketService#updateTicket(TicketModel)}
     */
    @Test
    void testUpdateTicket3() {
        when(ticketRepository.findById((Long) any())).thenReturn(Optional.empty());
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenReturn(new TicketModel());
        doNothing().when(ticketModelMapper)
                .updateTicketFromModel((TicketModel) any(), (TicketEntity) any(), (CycleAvoidingMappingContext) any());
        assertThrows(ExceptionHandler.class, () -> ticketService.updateTicket(new TicketModel()));
        verify(ticketRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TicketService#updateTicket(TicketModel)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateTicket4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "Object.toString()" because "model" is null
        //       at com.diy.service.TicketService.updateTicket(TicketService.java:68)
        //   See https://diff.blue/R013 to resolve this issue.

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<TicketEntity> ofResult = Optional.of(ticketEntity);
        when(ticketRepository.findById((Long) any())).thenReturn(ofResult);
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenReturn(new TicketModel());
        doNothing().when(ticketModelMapper)
                .updateTicketFromModel((TicketModel) any(), (TicketEntity) any(), (CycleAvoidingMappingContext) any());
        ticketService.updateTicket(null);
    }

    /**
     * Method under test: {@link TicketService#createTicket(TicketModel)}
     */
    @Test
    void testCreateTicket() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(ticketRepository.save((TicketEntity) any())).thenReturn(ticketEntity);

        TicketEntity ticketEntity1 = new TicketEntity();
        ticketEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity1.setCustomerId(1L);
        ticketEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity1.setDescription("The characteristics of someone or something");
        ticketEntity1.setProblemType(ProblemType.Business);
        ticketEntity1.setSenderType(SenderType.Store);
        ticketEntity1.setState(State.Closed);
        ticketEntity1.setStoreId(1L);
        ticketEntity1.setTicketId(1L);
        ticketEntity1.setTitle("Dr");
        ticketEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        TicketModel ticketModel = new TicketModel();
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenReturn(ticketModel);
        when(ticketModelMapper.modelToEntity((TicketModel) any())).thenReturn(ticketEntity1);
        assertSame(ticketModel, ticketService.createTicket(new TicketModel()));
        verify(ticketRepository).save((TicketEntity) any());
        verify(ticketModelMapper).modelToEntity((TicketModel) any());
        verify(ticketModelMapper).entityToModel((TicketEntity) any());
    }

    /**
     * Method under test: {@link TicketService#createTicket(TicketModel)}
     */
    @Test
    void testCreateTicket2() {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setCustomerId(1L);
        ticketEntity.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity.setDescription("The characteristics of someone or something");
        ticketEntity.setProblemType(ProblemType.Business);
        ticketEntity.setSenderType(SenderType.Store);
        ticketEntity.setState(State.Closed);
        ticketEntity.setStoreId(1L);
        ticketEntity.setTicketId(1L);
        ticketEntity.setTitle("Dr");
        ticketEntity.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(ticketRepository.save((TicketEntity) any())).thenReturn(ticketEntity);

        TicketEntity ticketEntity1 = new TicketEntity();
        ticketEntity1.setCreatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity1.setCustomerId(1L);
        ticketEntity1.setDeletedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        ticketEntity1.setDescription("The characteristics of someone or something");
        ticketEntity1.setProblemType(ProblemType.Business);
        ticketEntity1.setSenderType(SenderType.Store);
        ticketEntity1.setState(State.Closed);
        ticketEntity1.setStoreId(1L);
        ticketEntity1.setTicketId(1L);
        ticketEntity1.setTitle("Dr");
        ticketEntity1.setUpdatedAt(LocalDateTime.of(1, 1, 1, 1, 1));
        when(ticketModelMapper.entityToModel((TicketEntity) any())).thenThrow(new ExceptionHandler("An error occurred"));
        when(ticketModelMapper.modelToEntity((TicketModel) any())).thenReturn(ticketEntity1);
        assertThrows(ExceptionHandler.class, () -> ticketService.createTicket(new TicketModel()));
        verify(ticketRepository).save((TicketEntity) any());
        verify(ticketModelMapper).modelToEntity((TicketModel) any());
        verify(ticketModelMapper).entityToModel((TicketEntity) any());
    }
}

