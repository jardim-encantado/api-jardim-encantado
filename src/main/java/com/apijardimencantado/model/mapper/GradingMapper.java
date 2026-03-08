package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Grading;
import com.apijardimencantado.model.database.Student;
import com.apijardimencantado.model.database.StudySubject;
import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.dto.request.GradingRequest;
import com.apijardimencantado.model.dto.response.GradingResponse;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.model.dto.response.StudySubjectResponse;
import com.apijardimencantado.model.dto.response.TeacherResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GradingMapper {

    @Mapping(target = "student", source = "student")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "givenByTeacherId", source = "teacher")
    @Mapping(target = "bimonthly", source = "bimonthly")
    Grading toEntity(GradingRequest request, Teacher teacher, Student student, StudySubject subject, Integer bimonthly);

    @Mapping(target = "student", source = "student")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "givenBy", source = "teacher")
    GradingResponse toResponse(Grading grading, StudentResponse student, StudySubjectResponse subject, TeacherResponse teacher);

}