package com.apijardimencantado.mapper;

import com.apijardimencantado.model.database.ClassroomGroup;
import com.apijardimencantado.model.database.ClassroomGroupStudent;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.response.ClassroomGroupStudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassroomGroupStudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "classroomGroup", source = "group")
    @Mapping(target = "student", source = "student")
    ClassroomGroupStudent toEntity(ClassroomGroup group, Student student);

    @Mapping(target = "groupId", source = "classroomGroup.groupId")
    @Mapping(target = "studentId", source = "student.id")
    ClassroomGroupStudentResponse toResponse(ClassroomGroupStudent entity);
}