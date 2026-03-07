package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.AdminContract;
import com.apijardimencantado.model.dto.request.AdminRequest;
import com.apijardimencantado.model.dto.response.AdminResponse;
import com.apijardimencantado.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
@RequiredArgsConstructor
public class AdminController implements AdminContract {

    private final AdminService adminService;

    @Override
    @PostMapping
    public AdminResponse create(@RequestBody AdminRequest adminRequest) {
        return adminService.create(adminRequest);
    }

    @Override
    @GetMapping
    public List<AdminResponse> getAll() {
        return adminService.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public AdminResponse getById(@PathVariable Long id) {
        return adminService.getById(id);
    }

    @Override
    @PutMapping("/{id}")
    public AdminResponse update(
            @PathVariable Long id,
            @RequestBody AdminRequest adminRequest
    ) {
        return adminService.update(id, adminRequest);
    }
}