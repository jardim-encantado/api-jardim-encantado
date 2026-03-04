package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.TeacherSubject;
import com.apijardimencantado.model.dto.request.TeacherSubjectRequest;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherSubjectMapper {
    TeacherSubject toEntity(TeacherSubjectRequest request);

    TeacherSubjectResponse toResponse(TeacherSubject entity);

}
