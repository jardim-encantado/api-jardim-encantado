package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.mapper.PersonMapper;
import com.apijardimencantado.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person, Long, PersonRequest, PersonResponse> {
    private final PersonMapper mapper;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        super(personRepository, "Person");
        this.mapper = personMapper;
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
