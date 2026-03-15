package com.apijardimencantado.controller.teacher;

import com.apijardimencantado.controller.contract.teacher.TeacherContract;
import com.apijardimencantado.model.dto.request.TeacherRequest;
import com.apijardimencantado.model.dto.response.TeacherResponse;
import com.apijardimencantado.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController implements TeacherContract {

    private final TeacherService service;

    @GetMapping
    public List<TeacherResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TeacherResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TeacherResponse create(@RequestBody TeacherRequest request) {
        return service.create(request);
    }
}