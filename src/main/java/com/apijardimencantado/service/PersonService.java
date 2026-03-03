package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.Role;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.mapper.PersonMapper;
import com.apijardimencantado.repository.PersonRepository;
import com.apijardimencantado.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService extends BaseService<Person, Long, PersonRequest, PersonResponse> {
    private final PersonMapper mapper;
    private final RoleRepository roleRepository;

    public PersonService(PersonMapper personMapper, PersonRepository personRepository, RoleRepository roleRepository) {
        super(personRepository, "Person");
        this.mapper = personMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public PersonResponse create(PersonRequest request) {
        log.info("[PersonService] [create] CREATE");

        Person entity = toEntity(request);

        Role role = roleRepository
                .findById(request.roleId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Role not found: " + request.roleId())
                );

        entity.setRole(role);

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
