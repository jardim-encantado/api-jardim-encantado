package com.apijardimencantado.model.mapper;

import com.apijardimencantado.model.database.Role;
import com.apijardimencantado.model.dto.request.RoleRequest;
import com.apijardimencantado.model.dto.response.RoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "id", ignore = true)
    Role toEntity(RoleRequest request);

    RoleResponse toResponse(Role role);

}
