package com.apijardimencantado.service;

import com.apijardimencantado.model.database.*;
import com.apijardimencantado.model.dto.request.TeacherSubjectRequest;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import com.apijardimencantado.model.mapper.TeacherSubjectMapper;
import com.apijardimencantado.repository.*;
import org.springframework.stereotype.Service;

@Service
public class TeacherSubjectService extends BaseService<TeacherSubject, Long,
        TeacherSubjectRequest, TeacherSubjectResponse> {

    private final TeacherSubjectMapper mapper;
    private final TeacherService teacherService;
    private final StudySubjectService subjectService;

    public TeacherSubjectService(
            TeacherSubjectRepository repository,
            TeacherSubjectMapper mapper,
            TeacherService teacherService,
            StudySubjectService subjectService
    ) {
        super(repository, "TeacherSubject");
        this.mapper = mapper;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @Override
    protected TeacherSubject toEntity(TeacherSubjectRequest request) {
        Teacher teacher = teacherService.getModelById(request.teacherId());
        StudySubject subject = subjectService.getModelById(request.subjectId());

        return TeacherSubject.builder()
                .teacher(teacher)
                .subject(subject)
                .build();
    }

    @Override
    protected TeacherSubjectResponse toResponse(TeacherSubject entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(TeacherSubject entity, TeacherSubjectRequest request) {
        throw new UnsupportedOperationException("TeacherSubject relation cannot be updated. " +
                "Create a new relation instead.");
    }
}