package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Address;
import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.database.Role;
import com.apijardimencantado.model.dto.request.LoginRequest;
import com.apijardimencantado.model.dto.request.PersonRequest;
import com.apijardimencantado.model.dto.response.AddressResponse;
import com.apijardimencantado.model.dto.response.PersonResponse;
import com.apijardimencantado.model.mapper.AddressMapper;
import com.apijardimencantado.model.mapper.PersonMapper;
import com.apijardimencantado.repository.person.AddressRepository;
import com.apijardimencantado.repository.person.PersonRepository;
import com.apijardimencantado.repository.person.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService extends BaseService<Person, Long, PersonRequest, PersonResponse> {
    private final PersonMapper mapper;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    private final PersonRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    public PersonService(PersonMapper personMapper, PersonRepository personRepository,
                         PasswordEncoder passwordEncoder, RoleRepository roleRepository,
                         AddressMapper addressMapper, AddressRepository addressRepository) {
        super(personRepository, "Person");
        this.mapper = personMapper;
        this.repository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public PersonResponse create(PersonRequest request){
            log.info("[PersonService] [create] CREATE");
            Person person = repository.save(toEntity(request));
            Address address = addressMapper.toEntity(request.address());
            address.setPerson(person);
            addressRepository.save(address);

            return toResponse(person);
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
    protected Person toEntity(PersonRequest request) {
        Role role = roleRepository.findById(request.roleId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found."));

        return mapper.toEntity(request, role);
    }

    @Override
    protected PersonResponse toResponse(Person person) {
        AddressResponse address = addressMapper.toResponse(
                addressRepository.findAddressByPerson_Id(person.getId()));
        return mapper.toResponse(person, address);
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

