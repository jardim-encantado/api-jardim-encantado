package com.apijardimencantado.service;

import com.apijardimencantado.model.database.Role;
import com.apijardimencantado.model.dto.request.RoleRequest;
import com.apijardimencantado.model.dto.response.RoleResponse;
import com.apijardimencantado.model.mapper.RoleMapper;
import com.apijardimencantado.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends BaseService<Role, Long, RoleRequest, RoleResponse> {
    private final RoleMapper mapper;

    public RoleService(RoleRepository roleRepository, RoleMapper mapper) {
        super(roleRepository, "Role");
        this.mapper = mapper;
    }

    public Role toEntity(RoleRequest request) {
        return mapper.toEntity(request);
    }
    public RoleResponse toResponse(Role role) {
        return mapper.toResponse(role);
    }
    public void updateEntity(Role role, RoleRequest request) {
        role.setName(request.name());
    }
}
