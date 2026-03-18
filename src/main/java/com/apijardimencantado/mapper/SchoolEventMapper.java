package com.apijardimencantado.mapper;

import com.apijardimencantado.model.database.SchoolEvent;
import com.apijardimencantado.model.database.SchoolEventType;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.SchoolEventRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.dto.response.SchoolEventResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SchoolEventMapper {
    @Mapping(target = "eventId", ignore = true)
    @Mapping(source = "request.cpf", target = "createdBy.cpf")
    @Mapping(source = "request.name", target = "name")
    @Mapping(source = "eventType", target = "eventType")
    @Mapping(source = "student", target = "student")
    SchoolEvent toEntity(SchoolEventRequest request, SchoolEventType eventType, Student student);


    @Mapping(source="person", target = "createdBy")
    SchoolEventResponse toResponse(SchoolEvent schoolEvent, PersonResponse person);

}
