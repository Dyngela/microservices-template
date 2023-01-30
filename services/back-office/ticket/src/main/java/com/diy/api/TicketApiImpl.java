package com.diy.api;

import com.diy.generated.api.TicketApi;
import com.diy.generated.model.TicketDto;
import com.diy.mapper.TicketModelMapper;
import com.diy.service.TicketService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TicketApiImpl implements TicketApi {

    TicketService service;
    TicketModelMapper mapper;

    @Override
    public ResponseEntity<List<TicketDto>> findCustomersTicketByStoreId(Long storeId) {
        return ResponseEntity.ok(mapper.modelsToDtos(service.findCustomersTicketByStoreId(storeId)));
    }

    @Override
    public ResponseEntity<List<TicketDto>> findStoreTicketByStoreId(Long storeId) {
        return ResponseEntity.ok(mapper.modelsToDtos(service.findStoreTicketByStoreId(storeId)));
    }

    @Override
    public ResponseEntity<TicketDto> findTicketById(Long ticketId) {
        return ResponseEntity.ok(mapper.modelToDto(service.findTicketById(ticketId)));
    }

    @Override
    public ResponseEntity<TicketDto> updateTicket(TicketDto ticketDto) {
        return ResponseEntity.ok(mapper.modelToDto(service.updateTicket(mapper.dtoToModel(ticketDto))));
    }

    @Override
    public ResponseEntity<TicketDto> createTicket(TicketDto ticketDto) {
        return ResponseEntity.ok(mapper.modelToDto(service.createTicket(mapper.dtoToModel(ticketDto))));
    }
}
