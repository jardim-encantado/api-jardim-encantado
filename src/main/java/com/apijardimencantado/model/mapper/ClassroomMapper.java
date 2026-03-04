package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Classroom;
import com.apijardimencantado.model.dto.request.ClassroomRequest;
import com.apijardimencantado.model.dto.response.ClassroomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {
    @Mapping(target = "classroom_id", ignore = true)
    Classroom toEntity(ClassroomRequest request);
    ClassroomResponse toResponse(Classroom classroom);

}
