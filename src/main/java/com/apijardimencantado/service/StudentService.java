package com.apijardimencantado.service;

import com.apijardimencantado.exception.StudentNotFoundException;
import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.database.enrollment.Enrollment;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.model.mapper.StudentMapper;
import com.apijardimencantado.repository.PersonRepository;
import com.apijardimencantado.repository.student.EnrollmentRepository;
import com.apijardimencantado.repository.student.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentMapper mapper;
    private final StudentRepository studentRepository;
    private final PersonRepository personRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    public StudentResponse create(StudentRequest request) {
        Person person = personRepository.save(mapper.toPersonEntity(request));
        Student student = mapper.toEntity(request);
        student = studentRepository.save(student);
        return mapper.toResponse(student, person);
    }

    @Transactional
    public StudentResponse update(Long id, StudentRequest request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found: " + id));

        Person person = student.getPerson();
        if (person == null) {
            person = personRepository.save(mapper.toPersonEntity(request));
            student.setPerson(person);
        } else {
            // Update person fields
            person.setFirstName(request.firstName());
            person.setLastName(request.lastName());
            person.setCpf(request.cpf());
            person.setEmail(request.email());
            if (request.password() != null && !request.password().isBlank()) {
                person.setPassword(request.password());
            }
            person.setPhotoUrl(request.photoUrl());
            personRepository.save(person);
        }

        student = studentRepository.save(student);
        return mapper.toResponse(student, person);
    }

    private Student getModelById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public StudentResponse getById(Long id) {
        Student student = getModelById(id);
        return mapper.toResponse(student, student.getPerson());
    }

    private StudentResponse changeEnrollment(Long studentId, Consumer<Enrollment> action) {
        Student student = getModelById(studentId);
        action.accept(student.getEnrollment());
        studentRepository.save(student);
        return mapper.toResponse(student, student.getPerson());
    }

    public StudentResponse enroll(Long studentId) {
        return changeEnrollment(studentId, Enrollment::finish);
    }

    public StudentResponse rejectEnrollment(Long studentId) {
        return changeEnrollment(studentId, Enrollment::reject);
    }
}
