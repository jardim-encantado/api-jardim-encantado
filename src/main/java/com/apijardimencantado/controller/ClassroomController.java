package com.apijardimencantado.controller;

import com.apijardimencantado.model.dto.request.ClassroomRequest;
import com.apijardimencantado.model.dto.response.ClassroomResponse;
import com.apijardimencantado.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/classroom")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<ClassroomResponse> create(@RequestBody ClassroomRequest classroomRequest) {
        ClassroomResponse response = classroomService.create(classroomRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClassroomResponse>> getAll() {
        return ResponseEntity.ok(classroomService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomResponse> update(
            @PathVariable Long id,
            @RequestBody ClassroomRequest classroomRequest
    ) {
        return ResponseEntity.ok(classroomService.update(id, classroomRequest));
    }

}
