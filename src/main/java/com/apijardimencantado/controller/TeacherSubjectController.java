package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.TeacherSubjectContract;
import com.apijardimencantado.model.dto.request.TeacherSubjectRequest;
import com.apijardimencantado.model.dto.response.TeacherSubjectResponse;
import com.apijardimencantado.service.TeacherSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher-subjects")
@RequiredArgsConstructor
public class TeacherSubjectController implements TeacherSubjectContract {

    private final TeacherSubjectService service;

    @GetMapping
    public List<TeacherSubjectResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TeacherSubjectResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TeacherSubjectResponse create(@RequestBody TeacherSubjectRequest request) {
        return service.create(request);
    }
}