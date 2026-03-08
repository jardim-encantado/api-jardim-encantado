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
@RequestMapping("/api/v1/students")
public class StudentController implements StudentContract {

    private final StudentService studentService;

    @Override
    @PostMapping
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        return studentService.create(request);
    }

    @Override
    @PatchMapping("/{studentId}/enrollment/finish")
    public StudentResponse finishEnrollment(Long id) {
        return studentService.enroll(id);
    }

    @Override
    @PatchMapping("/{studentId}/enrollment/approve")
    public StudentResponse rejectEnrollment(Long studentId) {
        return studentService.rejectEnrollment(studentId);
    }

    @Override
    @GetMapping
    public List<StudentResponse> getAll() {
        return studentService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return studentService.getById(id);
    }
}
