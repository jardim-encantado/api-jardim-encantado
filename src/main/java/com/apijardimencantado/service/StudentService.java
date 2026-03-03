package com.apijardimencantado.service;

import com.apijardimencantado.exception.StudentNotFoundException;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.database.enrollment.Enrollment;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.model.mapper.StudentMapper;
import com.apijardimencantado.repository.student.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class StudentService extends BaseService<Student, Long, StudentRequest, StudentResponse> {

    private final StudentMapper mapper;
    private final StudentRepository studentRepository;

    public StudentService(StudentMapper mapper, StudentRepository studentRepository) {
        super(studentRepository, "Student");
        this.mapper = mapper;
        this.studentRepository = studentRepository;
    }

    private Student getModelById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    @Override
    protected Student toEntity(StudentRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected StudentResponse toResponse(Student entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(Student entity, StudentRequest request) {
        throw new UnsupportedOperationException();
    }

    public StudentResponse getById(Long id) {
        Student student = getModelById(id);
        return mapper.toResponse(student);
    }

    private StudentResponse changeEnrollment(Long studentId, Consumer<Enrollment> action) {
        Student student = getModelById(studentId);
        action.accept(student.getEnrollment());
        studentRepository.save(student);
        return mapper.toResponse(student);
    }

    public StudentResponse enroll(Long studentId) {
        return changeEnrollment(studentId, Enrollment::finish);
    }

    public StudentResponse rejectEnrollment(Long studentId) {
        return changeEnrollment(studentId, Enrollment::reject);
    }
}
