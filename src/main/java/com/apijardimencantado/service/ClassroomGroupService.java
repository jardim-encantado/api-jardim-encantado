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

        if (!classroomRepository.existsById(request.classroom_id())
                || !teacherRepository.existsById(request.teacher_id())) {

            throw new EntityNotFoundException(
                    "Classroom or Teacher not found. Classroom ID: "
                            + request.classroom_id()
                            + ", Teacher ID: "
                            + request.teacher_id()
            );
        }

        ClassroomGroup entity = toEntity(request);
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

        Classroom classroom = classroomRepository.findById(request.classroom_id())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Classroom not found with id: " + request.classroom_id()
                ));

        Teacher teacher = teacherRepository.findById(request.teacher_id())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Teacher not found with id: " + request.teacher_id()
                ));

        entity.setClassroom_id(classroom.getClassroom_id());
        entity.setTeacher_id(teacher.getTeacher_id());
    }
}
