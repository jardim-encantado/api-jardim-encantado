package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Guardian;
import com.apijardimencantado.model.dto.request.GuardianRequest;
import com.apijardimencantado.model.dto.response.GuardianResponse;
import com.apijardimencantado.model.mapper.GuardianMapper;
import com.apijardimencantado.repository.PersonRepository;
import com.apijardimencantado.repository.student.GuardianRepository;

public class GuardianService extends BaseService<Guardian, Long, GuardianRequest, GuardianResponse> {

    private GuardianRepository repository;
    private GuardianMapper mapper;

    private PersonRepository personRepository;

    public GuardianService(GuardianRepository repository, GuardianMapper mapper) {
        super(repository, "Guardian");
    }

    @Override
    protected Guardian toEntity(GuardianRequest request) {
        return null;
    }

    @Override
    protected GuardianResponse toResponse(Guardian entity) {
        return null;
    }

    @Override
    protected void updateEntity(Guardian entity, GuardianRequest request) {

    }
}
