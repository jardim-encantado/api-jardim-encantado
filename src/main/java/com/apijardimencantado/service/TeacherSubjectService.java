package com.apijardimencantado.service;

import com.apijardimencantado.model.database.*;
import com.apijardimencantado.model.dto.request.TeacherSubjectRequest;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import com.apijardimencantado.model.mapper.TeacherSubjectMapper;
import com.apijardimencantado.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TeacherSubjectService extends BaseService<TeacherSubject, Long,
        TeacherSubjectRequest, TeacherSubjectResponse> {

    private final TeacherSubjectMapper mapper;
    private final TeacherRepository teacherRepository;
    private final StudySubjectRepository subjectRepository;

    public TeacherSubjectService(
            TeacherSubjectRepository repository,
            TeacherSubjectMapper mapper,
            TeacherRepository teacherRepository,
            StudySubjectRepository subjectRepository
    ) {
        super(repository, "TeacherSubject");
        this.mapper = mapper;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    protected TeacherSubject toEntity(TeacherSubjectRequest request) {
        Teacher teacher = teacherRepository.findById(request.teacherId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Teacher with ID " + request.teacherId() + " not found")
                );

        StudySubject subject = subjectRepository.findById(request.subjectId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Subject with ID " + request.subjectId() + " not found")
                );

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