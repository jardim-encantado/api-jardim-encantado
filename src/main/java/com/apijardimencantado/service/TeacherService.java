package com.apijardimencantado.service;

import com.apijardimencantado.model.database.*;
import com.apijardimencantado.model.dto.request.TeacherRequest;
import com.apijardimencantado.model.dto.response.TeacherResponse;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import com.apijardimencantado.model.mapper.TeacherMapper;
import com.apijardimencantado.model.mapper.TeacherSubjectMapper;
import com.apijardimencantado.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService extends BaseService<Teacher, Long, TeacherRequest, TeacherResponse> {

    private final TeacherMapper mapper;
    private final PersonRepository personRepository;
    private final TeacherSubjectRepository teacherSubjectRepository;
    private final TeacherSubjectMapper teacherSubjectMapper;

    public TeacherService(TeacherRepository repository, TeacherMapper mapper, PersonRepository personRepository,
            TeacherSubjectRepository teacherSubjectRepository, TeacherSubjectMapper teacherSubjectMapper) {
        super(repository, "Teacher");
        this.mapper = mapper;
        this.personRepository = personRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.teacherSubjectMapper = teacherSubjectMapper;
    }

    @Override
    public Teacher toEntity(TeacherRequest request) {
        Person person = personRepository.findByCpf(request.cpf());
        return Teacher.builder()
                .person(person)
                .build();
    }

    @Override
    public TeacherResponse toResponse(Teacher teacher) {
        List<TeacherSubjectResponse> relations =
                teacherSubjectRepository.findByTeacherId(teacher.getId())
                        .stream()
                        .map(teacherSubjectMapper::toResponse)
                        .toList();

        return mapper.toResponse(teacher, relations);
    }

    @Override
    public void updateEntity(Teacher entity, TeacherRequest request) {
        throw new UnsupportedOperationException("Unable to update teacher");
    }
}