package com.apijardimencantado.service;

import com.apijardimencantado.mapper.*;
import com.apijardimencantado.model.database.Grading;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.database.StudySubject;
import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.dto.request.GradingRequest;
import com.apijardimencantado.model.dto.response.AddressResponse;
import com.apijardimencantado.model.dto.response.GradingResponse;
import com.apijardimencantado.repository.grading.GradingRepository;
import com.apijardimencantado.repository.person.AddressRepository;
import com.apijardimencantado.repository.student.StudentRepository;
import com.apijardimencantado.repository.teacher.StudySubjectRepository;
import com.apijardimencantado.repository.teacher.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class GradingService extends BaseService<Grading, Long, GradingRequest, GradingResponse> {

    private final GradingMapper mapper;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;
    private final StudySubjectMapper subjectMapper;
    private final StudentRepository studentRepository;
    private final StudySubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final GradingRepository repository;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public GradingService(
            GradingRepository repository,
            GradingMapper mapper,
            StudentMapper studentMapper,
            TeacherMapper teacherMapper,
            StudySubjectMapper subjectMapper,
            StudentRepository studentRepository,
            StudySubjectRepository subjectRepository,
            TeacherRepository teacherRepository,
            AddressMapper addressMapper,
            AddressRepository addressRepository
    ) {
        super(repository, "Grading");
        this.mapper = mapper;
        this.studentMapper = studentMapper;
        this.teacherMapper = teacherMapper;
        this.subjectMapper = subjectMapper;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.repository = repository;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public List<GradingResponse> findByPersonId(Long personId) {
        return repository.findByStudent_Person_Id(personId)
                .stream()
                .map(this::toResponse)
                .toList();
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

        return mapper.toResponse(entity,
                studentMapper.toResponse(entity.getStudent(), getAddress(entity.getStudent().getPerson().getId())),
                subjectMapper.toResponse(entity.getSubject()),
                teacherMapper.toResponse(entity.getGivenByTeacherId(), null));
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
        return (LocalDate.now().getMonthValue() - 1) / 3 + 1;
    }

    private AddressResponse getAddress(Long personId) {
        return addressMapper.toResponse(
                addressRepository.findAddressByPerson_Id(personId));
    }
}