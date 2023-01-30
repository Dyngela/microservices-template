package com.diy.mapper;

import com.diy.entity.TicketEntity;
import com.diy.generated.model.TicketDto;
import com.diy.model.TicketModel;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TicketModelMapper {
    TicketDto modelToDto(TicketModel model);
    TicketEntity modelToEntity(TicketModel model);
    List<TicketDto> modelsToDtos(List<TicketModel> model);
    List<TicketModel> entitiesToModels(List<TicketEntity> model);
    TicketModel dtoToModel(TicketDto dto);
    TicketModel entityToModel(TicketEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTicketFromModel(TicketModel model, @MappingTarget TicketEntity entity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

}
