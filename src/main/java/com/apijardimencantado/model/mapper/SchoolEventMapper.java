package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.SchoolEvent;
import com.apijardimencantado.model.dto.request.SchoolEventRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.dto.response.SchoolEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolEventMapper {
    @Mapping(target = "eventId", ignore = true)
    @Mapping(source = "cpf", target = "createdBy.cpf")
    @Mapping(source = "eventTypeId", target = "eventTypeId.eventTypeId")
    SchoolEvent toEntity(SchoolEventRequest request);


    @Mapping(source="createdBy.id", target = "createdBy")
    SchoolEventResponse toResponse(SchoolEvent schoolEvent);

}
