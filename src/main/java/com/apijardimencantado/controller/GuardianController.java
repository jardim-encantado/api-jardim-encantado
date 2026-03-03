package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.GuardianContract;
import com.apijardimencantado.model.dto.request.GuardianRequest;
import com.apijardimencantado.model.dto.response.GuardianResponse;
import com.apijardimencantado.service.GuardianService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/guardians")
public class GuardianController implements GuardianContract {

    private final GuardianService guardianService;

    public GuardianController(GuardianService guardianService) {
        this.guardianService = guardianService;
    }

    @Override
    public GuardianResponse create(@RequestBody GuardianRequest guardianRequest) {
        return guardianService.create(guardianRequest);
    }

    @Override
    public List<GuardianResponse> getAll() {
        return guardianService.getAll();
    }

    @Override
    public GuardianResponse getById(@PathVariable Long guardianId) {
        return guardianService.getById(guardianId);
    }

    @Override
    public void addStudent(@PathVariable Long guardianId, @PathVariable Long studentId) {
        guardianService.addStudent(guardianId, studentId);
    }

    @Override
    public void removeStudent(@PathVariable Long guardianId, @PathVariable Long studentId) {
        guardianService.removeStudent(guardianId, studentId);
    }
}
