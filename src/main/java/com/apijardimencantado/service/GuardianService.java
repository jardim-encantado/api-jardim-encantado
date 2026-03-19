package com.apijardimencantado.service;

import com.apijardimencantado.mapper.AddressMapper;
import com.apijardimencantado.model.database.Guardian;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.GuardianRequest;
import com.apijardimencantado.model.dto.response.AddressResponse;
import com.apijardimencantado.model.dto.response.GuardianResponse;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.mapper.GuardianMapper;
import com.apijardimencantado.mapper.StudentMapper;
import com.apijardimencantado.repository.person.AddressRepository;
import com.apijardimencantado.repository.person.PersonRepository;
import com.apijardimencantado.repository.student.GuardianRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class GuardianService extends BaseService<Guardian, Long, GuardianRequest, GuardianResponse> {

    private final GuardianRepository repository;
    private final StudentMapper studentMapper;
    private final GuardianMapper mapper;
    private final PersonRepository personRepository;
    private final StudentService studentService;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public GuardianService(GuardianRepository repository,
                           GuardianMapper mapper,
                           PersonRepository personRepository,
                           StudentMapper studentMapper,
                           StudentService studentService,
                           AddressMapper addressMapper,
                           AddressRepository addressRepository) {
        super(repository, "Guardian");
        this.mapper = mapper;
        this.repository = repository;
        this.personRepository = personRepository;
        this.studentMapper = studentMapper;
        this.studentService = studentService;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public GuardianResponse findByCpf(String cpf) {
        return toResponse(repository.findByPerson_Cpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("Person with CPF" + cpf + "not found")));
    }

    @Override
    protected Guardian toEntity(GuardianRequest request) {
        return Guardian.builder()
                .person(personRepository.findByCpf(request.cpf())
                        .orElseThrow(() -> new EntityNotFoundException("Person not found")))
                .build();
    }

    @Override
    protected GuardianResponse toResponse(Guardian entity) {
        List<StudentResponse> students = entity.getStudents() == null
                ? List.of()
                : getStudents(entity.getId());

        return mapper.toResponse(entity, students);
    }

    @Override
    protected void updateEntity(Guardian entity, GuardianRequest request) {
        throw new UnsupportedOperationException();
    }

    public List<StudentResponse> getStudents(Long guardianId) {
        Guardian guardian = getModelById(guardianId);
        return guardian.getStudents().stream()
                .map(student -> studentMapper.toResponse(
                        student,
                        getAddress(student.getPerson().getId())
                ))
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

    private AddressResponse getAddress(Long personId) {
        return addressMapper.toResponse(
                addressRepository.findAddressByPerson_Id(personId));
    }
}
