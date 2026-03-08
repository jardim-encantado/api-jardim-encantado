package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Classroom;
import com.apijardimencantado.model.database.ClassroomGroup;
import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.dto.request.ClassroomGroupRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupResponse;
import com.apijardimencantado.model.mapper.ClassroomGroupMapper;
import com.apijardimencantado.repository.ClassroomGroupRepository;
import com.apijardimencantado.repository.ClassroomRepository;
import com.apijardimencantado.repository.TeacherRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClassroomGroupService extends BaseService<ClassroomGroup, Long, ClassroomGroupRequest, ClassroomGroupResponse>{

    private final ClassroomGroupMapper mapper;
    private final ClassroomRepository classroomRepository;

    private final TeacherRepository teacherRepository;

    public ClassroomGroupService(ClassroomGroupRepository classroomGroupRepository, ClassroomGroupMapper classroomGroupMapper, ClassroomRepository classroomRepository, TeacherRepository teacherRepository) {
        super(classroomGroupRepository, "ClassroomGroup");
        this.mapper = classroomGroupMapper;
        this.teacherRepository = teacherRepository;
        this.classroomRepository = classroomRepository;
    }

    @Override
    @Transactional
    public ClassroomGroupResponse create(ClassroomGroupRequest request) {
        log.info("[ClassroomGroupService] [create] CREATE");

        if (!classroomRepository.existsClassroomByIdentifier(request.classroomId().identifier())
                || !teacherRepository.existsByPersonCpf(request.teacherId().cpf())) {

            throw new EntityNotFoundException(
                    "Classroom or Teacher not found. Classroom ID: "
                            + request.classroomId()
                            + ", Teacher ID: "
                            + request.teacherId()
            );
        }

        ClassroomGroup entity = toEntity(request);
        entity.setClassroomId(classroomRepository.findClassroomByIdentifier(request.classroomId().identifier()));
        entity.setTeacherId(teacherRepository.findTeacherByPersonCpf(request.teacherId().cpf()));
        return toResponse(repository.save(entity));
    }
    @Override
    protected ClassroomGroup toEntity(ClassroomGroupRequest request) {
        return mapper.toEntity(request);
    }

    @Override
    protected ClassroomGroupResponse toResponse(ClassroomGroup entity) {
        return mapper.toResponse(entity);
    }

    @Override
    protected void updateEntity(ClassroomGroup entity, ClassroomGroupRequest request) {

        entity.setName(request.name());
        entity.setSeries(request.series());

        Classroom classroom = classroomRepository.findClassroomByIdentifier(request.classroomId().identifier());
        Teacher teacher = teacherRepository.findTeacherByPersonCpf(request.teacherId().cpf());

        if (classroom == null || teacher == null) {
            throw new EntityNotFoundException(
                    "Classroom or Teacher not found. Classroom ID: "
                            + request.classroomId()
                            + ", Teacher ID: "
                            + request.teacherId()
            );
        }

        entity.setClassroomId(classroom);
        entity.setTeacherId(teacher);
    }
}
