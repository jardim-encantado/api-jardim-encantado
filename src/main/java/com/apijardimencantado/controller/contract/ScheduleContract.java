package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.ScheduleItemResponseDto;
import com.apijardimencantado.model.dto.ScheduleRequestDto;
import com.apijardimencantado.model.dto.ScheduleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/schedules")
public interface ScheduleContract {

    @PostMapping
    ResponseEntity<ScheduleResponseDto> create(@RequestBody ScheduleRequestDto dto);

    @GetMapping("/group/{groupId}")
    ResponseEntity<ScheduleResponseDto> getByGroup(@PathVariable Long groupId);

    @GetMapping("/student/{studentId}")
    ResponseEntity<ScheduleResponseDto> getByStudent(@PathVariable Long studentId);

    @GetMapping("/teacher/{teacherId}")
    ResponseEntity<List<ScheduleItemResponseDto>> getByTeacher(@PathVariable Long teacherId);

    @PutMapping("/{id}")
    ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}