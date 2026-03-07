package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.StudentContract;
import com.apijardimencantado.model.dto.request.StudentRequest;
import com.apijardimencantado.model.dto.response.StudentResponse;
import com.apijardimencantado.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
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

    @Override
    public List<StudentResponse> getAll() {
        return studentService.getAll();
    }

    @Override
    public StudentResponse getById(@PathVariable Long id) {
        return studentService.getById(id);
    }
}
