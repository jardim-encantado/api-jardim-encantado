package com.apijardimencantado.controller.contract;

import com.apijardimencantado.model.dto.ScheduleItemResponse;
import com.apijardimencantado.model.dto.ScheduleRequest;
import com.apijardimencantado.model.dto.ScheduleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/schedules")
public interface ScheduleContract {

    @PostMapping
    ResponseEntity<ScheduleResponse> create(@RequestBody ScheduleRequest dto);

    @GetMapping("/group/{groupId}")
    ResponseEntity<ScheduleResponse> getByGroup(@PathVariable Long groupId);

    @GetMapping("/student/{studentId}")
    ResponseEntity<ScheduleResponse> getByStudent(@PathVariable Long studentId);

    @GetMapping("/teacher/{teacherId}")
    ResponseEntity<List<ScheduleItemResponse>> getByTeacher(@PathVariable Long teacherId);

    @PutMapping("/{id}")
    ResponseEntity<ScheduleResponse> update(@PathVariable Long id, @RequestBody ScheduleRequest dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}