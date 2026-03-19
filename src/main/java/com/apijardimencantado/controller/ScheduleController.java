package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.ScheduleContract;
import com.apijardimencantado.model.dto.ScheduleItemResponseDto;
import com.apijardimencantado.model.dto.ScheduleRequestDto;
import com.apijardimencantado.model.dto.ScheduleResponseDto;
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
    public ResponseEntity<ScheduleResponseDto> create(ScheduleRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    public ResponseEntity<ScheduleResponseDto> getByGroup(Long groupId) {
        return ResponseEntity.ok(service.getByGroup(groupId));
    }

    @Override
    public ResponseEntity<ScheduleResponseDto> getByStudent(Long studentId) {
        return ResponseEntity.ok(service.getByStudent(studentId));
    }

    @Override
    public ResponseEntity<List<ScheduleItemResponseDto>> getByTeacher(Long teacherId) {
        return ResponseEntity.ok(service.getByTeacher(teacherId));
    }

    @Override
    public ResponseEntity<ScheduleResponseDto> update(Long id, ScheduleRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
