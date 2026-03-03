package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentRequest request);

    @Mapping(target = "personId", expression = "java(student != null && student.getPerson() != null && student.getPerson().getId() != null ? student.getPerson().getId().intValue() : null)")
    @Mapping(target = "studentId", expression = "java(student != null && student.getId() != null ? student.getId().intValue() : null)")
    StudentResponse toResponse(Student student);
}
