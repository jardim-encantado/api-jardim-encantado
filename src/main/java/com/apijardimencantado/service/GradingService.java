package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Grading;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.database.StudySubject;
import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.dto.request.GradingRequest;
import com.apijardimencantado.model.dto.response.GradingResponse;
import com.apijardimencantado.model.mapper.GradingMapper;
import com.apijardimencantado.repository.grading.GradingRepository;
import com.apijardimencantado.repository.student.StudentRepository;
import com.apijardimencantado.repository.teacher.StudySubjectRepository;
import com.apijardimencantado.repository.teacher.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class GradingService extends BaseService<Grading, Long, GradingRequest, GradingResponse> {

    private final GradingMapper mapper;
    private final StudentRepository studentRepository;
    private final StudySubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public GradingService(
            GradingRepository repository,
            GradingMapper mapper,
            StudentRepository studentRepository,
            StudySubjectRepository subjectRepository,
            TeacherRepository teacherRepository
    ) {
        super(repository, "Grading");
        this.mapper = mapper;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    protected Grading toEntity(GradingRequest request) {

        Student student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StudySubject subject = subjectRepository.findById(request.subjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Teacher teacher = teacherRepository.findById(request.givenByTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Grading grading = mapper.toEntity(request, teacher, student, subject, getCurrentBimonthly());

        grading.setStudent(student);
        grading.setSubject(subject);
        grading.setGivenByTeacherId(teacher);
        grading.setBimonthly(getCurrentBimonthly());

        return grading;
    }

    @Override
    protected GradingResponse toResponse(Grading entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(Grading entity, GradingRequest request) {

        Student student = studentRepository.findById(request.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        StudySubject subject = subjectRepository.findById(request.subjectId())
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Teacher teacher = teacherRepository.findById(request.givenByTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        entity.setStudent(student);
        entity.setSubject(subject);
        entity.setGrade(request.grade());
        entity.setObservations(request.observations());
        entity.setGivenByTeacherId(teacher);
    }

    private Integer getCurrentBimonthly() {

        int month = LocalDate.now().getMonthValue();

        if (month <= 3) return 1;
        if (month <= 6) return 2;
        if (month <= 9) return 3;
        return 4;
    }
}