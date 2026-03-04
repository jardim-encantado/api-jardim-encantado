package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.ClassroomGroup;
import com.apijardimencantado.model.dto.request.ClassroomGroupRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassroomGroupMapper {

    @Mapping(target = "group_id", ignore = true)
    ClassroomGroup toEntity(ClassroomGroupRequest request);
    ClassroomGroupResponse toResponse(ClassroomGroup classroomGroup);

}
