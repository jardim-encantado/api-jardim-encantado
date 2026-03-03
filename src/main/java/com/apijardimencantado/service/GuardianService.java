package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Guardian;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.GuardianRequest;
import com.apijardimencantado.model.dto.response.GuardianResponse;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.model.mapper.GuardianMapper;
import com.apijardimencantado.model.mapper.StudentMapper;
import com.apijardimencantado.repository.PersonRepository;
import com.apijardimencantado.repository.student.GuardianRepository;

import java.util.List;
import java.util.function.Consumer;

public class GuardianService extends BaseService<Guardian, Long, GuardianRequest, GuardianResponse> {

    private final StudentMapper studentMapper;
    private final GuardianMapper mapper;
    private final PersonRepository personRepository;
    private final StudentService studentService;

    public GuardianService(GuardianRepository repository,
                           GuardianMapper mapper,
                           PersonRepository personRepository,
                           StudentMapper studentMapper,
                           StudentService studentService) {
        super(repository, "Guardian");
        this.mapper = mapper;
        this.personRepository = personRepository;
        this.studentMapper = studentMapper;
        this.studentService = studentService;
    }

    @Override
    protected Guardian toEntity(GuardianRequest request) {
        return Guardian.builder()
                .person(personRepository.findByCpf(request.cpf()))
                .build();
    }

    @Override
    protected GuardianResponse toResponse(Guardian entity) {
        List<StudentResponse> students = entity.getStudents()
                .stream()
                .map(studentMapper::toResponse)
                .toList();

        return mapper.toResponse(entity, students);
    }

    @Override
    protected void updateEntity(Guardian entity, GuardianRequest request) {
        throw new UnsupportedOperationException();
    }

    public List<StudentResponse> getStudents(Long guardianId) {
        Guardian guardian = getModelById(guardianId);
        return guardian.getStudents().stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    private void studentListAction(Long guardianId, Consumer<List<Student>> action) {
        Guardian guardian = getModelById(guardianId);
        action.accept(guardian.getStudents());
        repository.save(guardian);
    }

    public void addStudent(Long guardianId, Long studentId) {
        studentListAction(guardianId, students -> {
            Student student = studentService.getModelById(studentId);
            students.add(student);
        });
    }

    public void removeStudent(Long guardianId, Long studentId) {
        studentListAction(guardianId, students -> {
            Student student = studentService.getModelById(studentId);
            students.remove(student);
        });
    }
}
