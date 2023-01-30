package com.diy.service;

import com.diy.entity.TicketEntity;
import com.diy.enums.SenderType;
import com.diy.exception.ExceptionHandler;
import com.diy.mapper.CycleAvoidingMappingContext;
import com.diy.mapper.TicketModelMapper;
import com.diy.model.TicketModel;
import com.diy.repository.TicketRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Log4j2
public class TicketService {

    TicketRepository repository;
    TicketModelMapper mapper;

    public List<TicketModel> findCustomersTicketByStoreId(Long storeId) {
        try {
            List<TicketEntity> entities = repository.findAllByStoreIdAndSenderTypeAndDeletedAt(storeId, SenderType.Customer, null);
            return mapper.entitiesToModels(entities);
        } catch (Exception e) {
            log.error("Error while finding customers ticket: " + e.getMessage());
            throw new ExceptionHandler("We could not find your tickets");
        }
    }

    public List<TicketModel> findStoreTicketByStoreId(Long storeId) {
        try {
            List<TicketEntity> entities = repository.findAllByStoreIdAndSenderTypeAndDeletedAt(storeId, SenderType.Store, null);
            return mapper.entitiesToModels(entities);
        } catch (Exception e) {
            log.error("Error while finding customers ticket: " + e.getMessage());
            throw new ExceptionHandler("We could not find your tickets");
        }
    }

    public TicketModel findTicketById(Long ticketId) {
        try {
            TicketEntity entity = repository.findById(ticketId).orElseThrow(() -> new ExceptionHandler("Ticket not found"));
            return mapper.entityToModel(entity);
        }  catch (Exception e) {
            log.error("Error while finding your ticket: " + e.getMessage());
            throw new ExceptionHandler("We could not find your ticket");
        }
    }

    public TicketModel updateTicket(TicketModel model) {
        try {
            TicketEntity entity = repository.findById(model.getTicketId()).orElseThrow(() -> new ExceptionHandler("Ticket not found"));
            mapper.updateTicketFromModel(model, entity, new CycleAvoidingMappingContext());
            entity.setUpdatedAt(LocalDateTime.now());
            return mapper.entityToModel(entity);
        } catch (Exception e) {
            log.error("Error while updating a ticket: " + e.getMessage());
            log.error("ticket model: " + model.toString());
            throw new ExceptionHandler("We could not update your ticket");
        }

    }

    public TicketModel createTicket(TicketModel model) {
        try {
            TicketEntity entity = mapper.modelToEntity(model);
            entity.setCreatedAt(LocalDateTime.now());
            repository.save(entity);
            return mapper.entityToModel(entity);
        } catch (Exception e) {
            log.error("Error while creating a ticket: " + e.getMessage());
            log.error("ticket model: " + model.toString());
            throw new ExceptionHandler("We could not create your ticket");
        }

    }
}
