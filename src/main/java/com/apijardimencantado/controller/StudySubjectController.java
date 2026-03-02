package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.StudySubjectContract;
import com.apijardimencantado.model.dto.request.StudySubjectRequest;
import com.apijardimencantado.model.dto.response.StudySubjectResponse;
import com.apijardimencantado.service.StudySubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class StudySubjectController implements StudySubjectContract {

    private final StudySubjectService service;

    @GetMapping
    public ResponseEntity<List<StudySubjectResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudySubjectResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<StudySubjectResponse> create(@RequestBody StudySubjectRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudySubjectResponse> update(
            @PathVariable Long id,
            @RequestBody StudySubjectRequest request
    ) {
        return ResponseEntity.ok(service.update(id, request));
    }
}