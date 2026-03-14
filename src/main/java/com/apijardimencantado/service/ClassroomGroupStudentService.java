package com.apijardimencantado.service;

import com.apijardimencantado.model.database.ClassroomGroup;
import com.apijardimencantado.model.database.ClassroomGroupStudent;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.ClassroomGroupStudentRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupStudentResponse;
import com.apijardimencantado.mapper.ClassroomGroupStudentMapper;
import com.apijardimencantado.repository.classroom.ClassroomGroupStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class ClassroomGroupStudentService extends BaseService<ClassroomGroupStudent, Integer,
        ClassroomGroupStudentRequest, ClassroomGroupStudentResponse> {

    private final ClassroomGroupStudentMapper mapper;
    private final ClassroomGroupService classroomGroupService;
    private final StudentService studentService;

    public ClassroomGroupStudentService(
            ClassroomGroupStudentRepository repository,
            ClassroomGroupStudentMapper mapper,
            ClassroomGroupService classroomGroupService,
            StudentService studentService
    ) {
        super(repository, "ClassroomGroupStudent");
        this.mapper = mapper;
        this.classroomGroupService = classroomGroupService;
        this.studentService = studentService;
    }

    @Override
    protected ClassroomGroupStudent toEntity(ClassroomGroupStudentRequest request) {
        ClassroomGroup group = classroomGroupService.getModelById(request.groupId());
        Student student = studentService.getModelById(request.studentId());

        return mapper.toEntity(group, student);
    }

    @Override
    protected ClassroomGroupStudentResponse toResponse(ClassroomGroupStudent entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(ClassroomGroupStudent entity, ClassroomGroupStudentRequest request) {
        throw new UnsupportedOperationException(
                "ClassroomGroupStudent relation cannot be updated. Create a new relation instead."
        );
    }
}