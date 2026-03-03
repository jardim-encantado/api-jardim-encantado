package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Student Controller", description = "Endpoints to manage persons")
@Validated
public interface StudentContract {

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    StudentResponse createStudent(StudentRequest request);

    @PatchMapping("/students/{studentId}/enrollment/finish")
    @ResponseStatus(HttpStatus.OK)
    StudentResponse finishEnrollment(@PathVariable Long studentId);

    @PatchMapping("/students/{studentId}/enrollment/approve")
    @ResponseStatus(HttpStatus.OK)
    StudentResponse rejectEnrollment(@PathVariable Long studentId);
}
