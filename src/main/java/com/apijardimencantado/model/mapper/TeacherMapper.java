package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.dto.request.TeacherRequest;
import com.apijardimencantado.model.dto.response.TeacherResponse;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity(TeacherRequest request);

    @Mapping(target = "personId", source = "teacher.person.id")
    @Mapping(target = "firstName", source = "teacher.person.firstName")
    @Mapping(target = "lastName", source = "teacher.person.lastName")
    @Mapping(target = "email", source = "teacher.person.email")
    @Mapping(target = "subjects", source = "subjects")
    TeacherResponse toResponse(Teacher teacher, List<TeacherSubjectResponse> subjects);
}