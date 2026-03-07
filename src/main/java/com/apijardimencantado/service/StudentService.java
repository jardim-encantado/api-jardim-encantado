package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.database.enrollment.Enrollment;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.model.mapper.StudentMapper;
import com.apijardimencantado.repository.PersonRepository;
import com.apijardimencantado.repository.student.EnrollmentRepository;
import com.apijardimencantado.repository.student.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Service
@Slf4j
public class StudentService extends BaseService<Student, Long, StudentRequest, StudentResponse> {

    private final StudentMapper mapper;
    private final StudentRepository studentRepository;
    private final PersonRepository personRepository;

    private final EnrollmentRepository enrollmentRepository;

    public StudentService(StudentMapper mapper, StudentRepository studentRepository, PersonRepository personRepository, EnrollmentRepository enrollmentRepository) {
        super(studentRepository, "Student");
        this.mapper = mapper;
        this.studentRepository = studentRepository;
        this.personRepository = personRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        Person person = personRepository.findByCpf(request.cpf());
        if (person.getRole().getId() != 1){
            throw new UnsupportedOperationException();
        }
        Enrollment enrollment = new Enrollment();
        enrollmentRepository.save(enrollment);
        Student student = new Student();
        student.setPerson(person);
        student.setEnrollment(enrollment);
        studentRepository.save(student);
        return toResponse(student);
    }

    @Override
    protected Student toEntity(StudentRequest request) {
        return Student.builder()
                .person(personRepository.findByCpf(request.cpf()))
                .build();
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
