package com.apijardimencantado.service;

import com.apijardimencantado.model.database.SchoolEventType;
import com.apijardimencantado.model.dto.response.SchoolEventTypeResponse;
import com.apijardimencantado.model.mapper.SchoolEventTypeMapper;
import com.apijardimencantado.repository.SchoolEventTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolEventTypeService {
    private final SchoolEventTypeRepository schoolEventTypeRepository;

    private final SchoolEventTypeMapper schoolEventTypeMapper;

    public SchoolEventTypeService(SchoolEventTypeRepository schoolEventTypeRepository, SchoolEventTypeMapper schoolEventTypeMapper) {
        this.schoolEventTypeRepository = schoolEventTypeRepository;
        this.schoolEventTypeMapper = schoolEventTypeMapper;
    }
    public SchoolEventTypeResponse getById(Long id) {
        SchoolEventType schoolEventType = schoolEventTypeRepository.findById(id).get();
        if (schoolEventType == null) {
            throw new EntityNotFoundException("Event type not found");
        }
        return schoolEventTypeMapper.toResponse(schoolEventType);
    }

    public List<SchoolEventTypeResponse> getAll() {
        List<SchoolEventType> events = schoolEventTypeRepository.findAll();
        List<SchoolEventTypeResponse> responses = new ArrayList<>();
        for (SchoolEventType event : events) {
            responses.add(schoolEventTypeMapper.toResponse(event));
        }
        return responses;
    }





}
