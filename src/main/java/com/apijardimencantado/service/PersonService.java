package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.mapper.PersonMapper;
import com.apijardimencantado.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService extends BaseService<Person, Long, PersonRequest, PersonResponse> {
    private final PersonMapper mapper;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        super(personRepository, "Person");
        this.mapper = personMapper;
    }

    @Override
    @Transactional
    public PersonResponse create(PersonRequest request) {
        log.info("[PersonService] [create] CREATE");
        Person entity = toEntity(request);
        return toResponse(repository.save(entity));
    }

    public Person toEntity(PersonRequest request) {
        return mapper.toEntity(request);
    }

    public PersonResponse toResponse(Person person) {
        return mapper.toResponse(person);
    }

    public void updateEntity(Person person, PersonRequest request) {
        person.setEmail(request.email());
        person.setFirstName(request.firstName());
        person.setLastName(request.lastName());
        if (request.password() != null && !request.password().isBlank()) {
            person.setPassword(request.password());
        }
        person.setPhotoUrl(request.photoUrl());
    }

}
