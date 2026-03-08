package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.ClassroomGroupContract;
import com.apijardimencantado.model.dto.request.ClassroomGroupRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupResponse;
import com.apijardimencantado.service.ClassroomGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classroomGroup")
@RequiredArgsConstructor
public class ClassroomGroupController implements ClassroomGroupContract {
    private final ClassroomGroupService classroomGroupService;

    @Override
    @PostMapping
    public ResponseEntity<ClassroomGroupResponse> create(@RequestBody ClassroomGroupRequest classroomGroupRequest) {
        ClassroomGroupResponse response = classroomGroupService.create(classroomGroupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ClassroomGroupResponse>> getAll() {
        return ResponseEntity.ok(classroomGroupService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClassroomGroupResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(classroomGroupService.getById(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ClassroomGroupResponse> update(
            @PathVariable Long id,
            @RequestBody ClassroomGroupRequest classroomGroupRequest
    ) {
        return ResponseEntity.ok(classroomGroupService.update(id, classroomGroupRequest));
    }

}
