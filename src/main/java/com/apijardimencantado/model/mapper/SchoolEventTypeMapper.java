package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.SchoolEventType;
import com.apijardimencantado.model.dto.response.SchoolEventTypeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolEventTypeMapper {
    SchoolEventTypeResponse toResponse(SchoolEventType schoolEventType);
}
