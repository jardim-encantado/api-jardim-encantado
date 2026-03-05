package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.ClassroomGroup;
import com.apijardimencantado.model.dto.request.ClassroomGroupRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = { ClassroomMapper.class }
)
public interface ClassroomGroupMapper {

    @Mapping(target = "groupId", ignore = true)
    @Mapping(target = "teacherId", ignore = true)
    @Mapping(target = "classroomId", ignore = true)
    ClassroomGroup toEntity(ClassroomGroupRequest request);

    ClassroomGroupResponse toResponse(ClassroomGroup entity);
}
