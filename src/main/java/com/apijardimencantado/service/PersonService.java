package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.dto.request.LoginRequest;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.mapper.PersonMapper;
import com.apijardimencantado.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService extends BaseService<Person, Long, PersonRequest, PersonResponse> {
    private final PersonMapper mapper;
    private final PersonRepository repository;
    private final PasswordEncoder passwordEncoder;



    public PersonService(PersonMapper personMapper, PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        super(personRepository, "Person");
        this.mapper = personMapper;
        this.repository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public PersonResponse login(LoginRequest request) {
        Person person = repository.findByCpf(request.cpf());
        if (person == null) {
            throw new EntityNotFoundException("Person not found");
        }
        if (!passwordEncoder.matches(request.password(), person.getPassword())) {
            throw new RuntimeException("Senha inválida");
        }
        return toResponse(person);
    }

    @Override
    @Transactional
    public PersonResponse create(PersonRequest request) {
        log.info("[PersonService] [create] CREATE");

        Person entity = repository.findById(repository.createPerson(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.cpf(),
                request.phoneNumber(),
                request.password(),
                request.roleId()
                )).orElseThrow();

        return toResponse(repository.save(entity));
    }

    @Override
    protected Person toEntity(PersonRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected PersonResponse toResponse(Person person) {
        return mapper.toResponse(person);
    }

    @Override
    protected void updateEntity(Person person, PersonRequest request) {
        person.setEmail(request.email());
        person.setFirstName(request.firstName());
        person.setLastName(request.lastName());
        if (request.password() != null && !request.password().isBlank()) {
            person.setPassword(request.password());
        }
        person.setPhotoUrl(request.photoUrl());
    }
}