package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.StudySubject;
import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.database.TeacherSubject;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TeacherSubjectMapper {
    @Mapping(target = "id", ignore = true)
    TeacherSubject toEntity(Teacher teacher, StudySubject subject);

    @Mapping(source = "id", target = "teacherSubjectId")
    @Mapping(source = "teacher.id", target = "teacherId")
    @Mapping(source = "teacher.person.firstName", target = "teacherName")
    @Mapping(source = "subject.subjectId", target = "subjectId")
    @Mapping(source = "subject.name", target = "subjectName")
    TeacherSubjectResponse toResponse(TeacherSubject entity);
}