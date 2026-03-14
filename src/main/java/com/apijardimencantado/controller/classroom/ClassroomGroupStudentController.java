package com.apijardimencantado.controller.classroom;

import com.apijardimencantado.controller.contract.classroom.ClassroomGroupStudentContract;
import com.apijardimencantado.model.dto.request.ClassroomGroupStudentRequest;
import com.apijardimencantado.model.dto.response.ClassroomGroupStudentResponse;
import com.apijardimencantado.service.ClassroomGroupStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classroom-group-students")
@RequiredArgsConstructor
public class ClassroomGroupStudentController implements ClassroomGroupStudentContract {

    private final ClassroomGroupStudentService service;

    @Override
    @PostMapping
    public ClassroomGroupStudentResponse create(@RequestBody ClassroomGroupStudentRequest request) {
        return service.create(request);
    }

    @Override
    @GetMapping
    public List<ClassroomGroupStudentResponse> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public ClassroomGroupStudentResponse getById(@PathVariable Integer id) {
        return service.getById(id);
    }
}