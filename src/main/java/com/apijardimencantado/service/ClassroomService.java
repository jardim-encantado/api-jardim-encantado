package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Classroom;
import com.apijardimencantado.model.dto.request.ClassroomRequest;
import com.apijardimencantado.model.dto.response.ClassroomResponse;
import com.apijardimencantado.model.mapper.ClassroomMapper;
import com.apijardimencantado.repository.ClassroomRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ClassroomService extends BaseService<Classroom, Long, ClassroomRequest, ClassroomResponse> {

    private final ClassroomMapper mapper;
    public ClassroomService(ClassroomRepository classroomRepository, ClassroomMapper mapper) {
        super(classroomRepository, "Classroom");
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ClassroomResponse create(ClassroomRequest request) {
        log.info("[ClassroomService] [create] CREATE");
        Classroom entity = toEntity(request);
        return toResponse(repository.save(entity));
    }

    @Override
    protected Classroom toEntity(ClassroomRequest request) {
        return mapper.toEntity(request);
    }
    @Override
    protected ClassroomResponse toResponse(Classroom entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(Classroom entity, ClassroomRequest request) {
        entity.setIdentifier(request.identifier());
    }
}
