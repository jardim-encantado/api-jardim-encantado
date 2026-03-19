package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.ScheduleContract;
import com.apijardimencantado.model.dto.ScheduleItemResponse;
import com.apijardimencantado.model.dto.ScheduleRequest;
import com.apijardimencantado.model.dto.ScheduleResponse;
import com.apijardimencantado.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController implements ScheduleContract {

    private final ScheduleService service;

    @Override
    public ResponseEntity<ScheduleResponse> create(ScheduleRequest dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    public ResponseEntity<ScheduleResponse> getByGroup(Long groupId) {
        return ResponseEntity.ok(service.getByGroup(groupId));
    }

    @Override
    public ResponseEntity<ScheduleResponse> getByStudent(Long studentId) {
        return ResponseEntity.ok(service.getByStudent(studentId));
    }

    @Override
    public ResponseEntity<List<ScheduleItemResponse>> getByTeacher(Long teacherId) {
        return ResponseEntity.ok(service.getByTeacher(teacherId));
    }

    @Override
    public ResponseEntity<ScheduleResponse> update(Long id, ScheduleRequest dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
