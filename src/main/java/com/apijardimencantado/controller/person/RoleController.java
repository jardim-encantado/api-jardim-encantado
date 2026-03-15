package com.apijardimencantado.controller.person;

import com.apijardimencantado.controller.contract.person.RoleContract;
import com.apijardimencantado.model.dto.response.RoleResponse;
import com.apijardimencantado.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController implements RoleContract {

    private final RoleService roleService;

    @GetMapping
    @Override
    public ResponseEntity<List<RoleResponse>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<RoleResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(roleService.getById(id));
    }
}
