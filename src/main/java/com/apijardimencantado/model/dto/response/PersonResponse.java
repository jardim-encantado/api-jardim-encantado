package com.apijardimencantado.model.dto.response;

public record PersonResponse(
        Long id,
        String firstName,
        String lastName,
        String photoUrl,
        Integer roleId,
        String roleName,
        AddressResponse address
) {}
