package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Admin;
import com.apijardimencantado.model.database.Person;
import com.apijardimencantado.model.dto.request.AdminRequest;
import com.apijardimencantado.model.dto.response.AdminResponse;
import com.apijardimencantado.repository.AdminRepository;
import com.apijardimencantado.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminService extends BaseService<
        Admin,
        Long,
        AdminRequest,
        AdminResponse
        > {

    private final PersonRepository personRepository;

    public AdminService(
            AdminRepository adminRepository,
            PersonRepository personRepository
    ) {
        super(adminRepository, "Admin");
        this.personRepository = personRepository;
    }

    @Override
    protected Admin toEntity(AdminRequest request) {
        Admin admin = new Admin();

        Person person = personRepository.findById(request.personId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Person with ID " + request.personId() + " not found.")
                );

        admin.setPerson(person);
        return admin;
    }

    @Override
    protected AdminResponse toResponse(Admin entity) {
        return new AdminResponse(
                entity.getAdminId(),
                entity.getPerson().getId()
        );
    }

    @Override
    protected void updateEntity(Admin entity, AdminRequest request) {

    }
}