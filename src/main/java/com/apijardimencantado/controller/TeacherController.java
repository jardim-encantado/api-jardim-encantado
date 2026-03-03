package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.TeacherContract;
import com.apijardimencantado.model.dto.request.TeacherRequest;
import com.apijardimencantado.model.dto.response.TeacherResponse;
import com.apijardimencantado.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController implements TeacherContract {

    private final TeacherService service;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherResponse> create(@RequestBody TeacherRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}