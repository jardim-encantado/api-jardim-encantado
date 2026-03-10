package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.SchoolEvent;
import com.apijardimencantado.model.database.SchoolEventType;
import com.apijardimencantado.model.dto.request.SchoolEventRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.dto.response.SchoolEventResponse;
import com.apijardimencantado.model.mapper.PersonMapper;
import com.apijardimencantado.model.mapper.SchoolEventMapper;
import com.apijardimencantado.repository.SchoolEventRepository;
import com.apijardimencantado.repository.SchoolEventTypeRepository;
import com.apijardimencantado.repository.person.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SchoolEventService extends BaseService<SchoolEvent, Long, SchoolEventRequest, SchoolEventResponse>{

    private final SchoolEventMapper mapper;
    private final SchoolEventTypeRepository schoolEventTypeRepository;
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    public SchoolEventService(SchoolEventRepository schoolEventRepository, SchoolEventMapper schoolEventMapper, SchoolEventTypeRepository schoolEventTypeRepository, PersonRepository personRepository, PersonMapper personMapper) {
        super(schoolEventRepository, "SchoolEvent");
        this.mapper = schoolEventMapper;
        this.schoolEventTypeRepository = schoolEventTypeRepository;
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Transactional
    public SchoolEventResponse create(SchoolEventRequest request) {
        Person person = personRepository.findByCpf(request.cpf());
        SchoolEventType schoolEventType = schoolEventTypeRepository.findById(request.eventTypeId()).get();
        if (person == null || schoolEventType == null) {
            throw new EntityNotFoundException("Creator or event type not found");
        }
        SchoolEvent schoolEvent = SchoolEvent.builder()
                .name(request.name())
                .description(request.description())
                .eventDate(request.eventDate())
                .createdBy(person)
                .eventTypeId(schoolEventType)
                .build();
        repository.save(schoolEvent);
        return toResponse(schoolEvent);
    }

    @Override
    protected SchoolEvent toEntity(SchoolEventRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected SchoolEventResponse toResponse(SchoolEvent entity) {
        PersonResponse createdBy = personMapper.toResponse(entity.getCreatedBy(), null);
        return mapper.toResponse(entity, createdBy);
    }

    @Override
    protected void updateEntity(SchoolEvent entity, SchoolEventRequest request) {
        Person person = personRepository.findByCpf(request.cpf());
        if (person == null) {
            throw new EntityNotFoundException("Creator not found");
        }
        entity.setName(request.name());
        entity.setDescription(request.description());
        entity.setCreatedBy(person);
        entity.setEventDate(request.eventDate());
        repository.save(entity);
    }
}
