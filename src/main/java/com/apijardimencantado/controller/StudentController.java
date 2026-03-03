package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.StudentContract;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class StudentController implements StudentContract {

    private final StudentService studentService;

    @Override
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        return studentService.create(request);
    }

    @Override
    public StudentResponse finishEnrollment(Long id) {
        return studentService.enroll(id);
    }

    @Override
    public StudentResponse rejectEnrollment(Long studentId) {
        return studentService.rejectEnrollment(studentId);
    }
}
