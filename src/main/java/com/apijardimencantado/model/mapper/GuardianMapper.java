package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Guardian;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.dto.request.GuardianRequest;
import com.apijardimencantado.model.dto.response.GuardianResponse;
import com.apijardimencantado.model.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuardianMapper {
    Guardian toEntity(GuardianRequest request);

    @Mapping(source = "guardian.id", target = "guardianId")
    @Mapping(source = "guardian.person.id", target = "personId")
    @Mapping(source = "guardian.person.firstName", target = "firstName")
    @Mapping(source = "guardian.person.lastName", target = "lastName")
    @Mapping(source = "guardian.person.email", target = "email")
    @Mapping(source = "students", target = "students")
    GuardianResponse toResponse(Guardian guardian, List<StudentResponse> students);
}
