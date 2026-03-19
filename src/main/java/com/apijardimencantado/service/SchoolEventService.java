package com.apijardimencantado.service;

import com.apijardimencantado.mapper.StudentMapper;
import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.SchoolEvent;
import com.apijardimencantado.model.database.SchoolEventType;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.SchoolEventRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.dto.response.SchoolEventResponse;
import com.apijardimencantado.mapper.PersonMapper;
import com.apijardimencantado.mapper.SchoolEventMapper;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.repository.SchoolEventRepository;
import com.apijardimencantado.repository.SchoolEventTypeRepository;
import com.apijardimencantado.repository.person.PersonRepository;
import com.apijardimencantado.repository.student.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SchoolEventService extends BaseService<SchoolEvent, Long, SchoolEventRequest, SchoolEventResponse>{

    private final SchoolEventMapper mapper;
    private final SchoolEventTypeRepository schoolEventTypeRepository;
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    public SchoolEventService(SchoolEventRepository schoolEventRepository,
                              SchoolEventMapper schoolEventMapper,
                              SchoolEventTypeRepository schoolEventTypeRepository,
                              PersonRepository personRepository,
                              PersonMapper personMapper,
                              StudentRepository studentRepository, StudentMapper studentMapper) {
        super(schoolEventRepository, "SchoolEvent");
        this.mapper = schoolEventMapper;
        this.schoolEventTypeRepository = schoolEventTypeRepository;
        this.personRepository = personRepository;
        this.personMapper = personMapper;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Transactional
    public SchoolEventResponse create(SchoolEventRequest request) {
        Person person = personRepository.findByCpf(request.cpf())
                .orElseThrow(() -> new EntityNotFoundException("Person not found"));
        SchoolEventType schoolEventType = schoolEventTypeRepository.findById(request.eventTypeId())
                .orElseThrow(() -> new EntityNotFoundException("School event type not found"));
        Student student = null;
        if (request.studentId() != null) {
            student = studentRepository.findById(request.studentId())
                    .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        }
        SchoolEvent schoolEvent = SchoolEvent.builder()
                .name(request.name())
                .description(request.description())
                .eventDate(request.eventDate())
                .createdBy(person)
                .eventType(schoolEventType)
                .student(student)
                .build();
        repository.save(schoolEvent);
        return toResponse(schoolEvent);
    }

    @Override
    protected SchoolEvent toEntity(SchoolEventRequest request) {
        SchoolEventType schoolEventType = schoolEventTypeRepository.findById(request.eventTypeId())
                .orElseThrow(() -> new EntityNotFoundException("School event type not found"));
        Student student = null;
        if (request.studentId() != null) {
            student = studentRepository.findById(request.studentId())
                    .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        }
        return mapper.toEntity(request, schoolEventType, student);
    }

    @Override
    protected SchoolEventResponse toResponse(SchoolEvent entity) {
        PersonResponse createdBy = personMapper.toResponse(entity.getCreatedBy(), null);
        StudentResponse student = studentMapper.toResponse(entity.getStudent());
        return mapper.toResponse(entity, createdBy, student
        );
    }

    @Override
    protected void updateEntity(SchoolEvent entity, SchoolEventRequest request) {
        Person person = personRepository.findByCpf(request.cpf())
                .orElseThrow(() -> new EntityNotFoundException("Creator not found"));
        entity.setName(request.name());
        entity.setDescription(request.description());
        entity.setCreatedBy(person);
        entity.setEventDate(request.eventDate());
        repository.save(entity);
    }
}
