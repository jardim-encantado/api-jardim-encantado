package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.StudySubject;
import com.apijardimencantado.model.dto.request.StudySubjectRequest;
import com.apijardimencantado.model.dto.response.StudySubjectResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StudySubjectMapper {
    @Mapping(target = "subjectId", ignore = true)
    StudySubject toEntity(StudySubjectRequest request);

    StudySubjectResponse toResponse(StudySubject subject);
}