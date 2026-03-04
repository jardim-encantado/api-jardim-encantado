package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentRequest request);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "personId", source = "student.person.id")
    @Mapping(target = "firstName", source = "student.person.firstName")
    @Mapping(target = "lastName", source = "student.person.lastName")
    @Mapping(target = "email", source = "student.person.email")
    StudentResponse toResponse(Student student);
}
