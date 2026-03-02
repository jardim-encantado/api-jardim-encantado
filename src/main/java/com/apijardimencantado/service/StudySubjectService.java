package com.apijardimencantado.service;

import com.apijardimencantado.model.database.StudySubject;
import com.apijardimencantado.model.dto.request.StudySubjectRequest;
import com.apijardimencantado.model.dto.response.StudySubjectResponse;
import com.apijardimencantado.model.mapper.StudySubjectMapper;
import com.apijardimencantado.repository.StudySubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class StudySubjectService extends BaseService<StudySubject, Long, StudySubjectRequest, StudySubjectResponse> {

    private final StudySubjectMapper mapper;

    public StudySubjectService(StudySubjectRepository repository, StudySubjectMapper mapper) {
        super(repository, "StudySubject");
        this.mapper = mapper;
    }

    @Override
    protected StudySubject toEntity(StudySubjectRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected StudySubjectResponse toResponse(StudySubject entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(StudySubject entity, StudySubjectRequest request) {
        entity.setName(request.name());
    }
}