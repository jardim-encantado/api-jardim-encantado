package com.apijardimencantado.controller;

import com.apijardimencantado.controller.contract.RoleContract;
import com.apijardimencantado.model.dto.request.RoleRequest;
import com.apijardimencantado.model.dto.response.RoleResponse;
import com.apijardimencantado.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController implements RoleContract {

    private final RoleService roleService;

    public ResponseEntity<List<RoleResponse>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    public ResponseEntity<RoleResponse> getById(Long id) {
        return ResponseEntity.ok(roleService.getById(id));
    }

    public ResponseEntity<RoleResponse> create(RoleRequest request) {
        RoleResponse response = roleService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<RoleResponse> update(Long id, RoleRequest request) {
        return ResponseEntity.ok(roleService.update(id, request));
    }
}
