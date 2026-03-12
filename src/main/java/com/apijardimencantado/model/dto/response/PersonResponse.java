package com.apijardimencantado.model.dto.response;

public record PersonResponse(
        Long id,
        String firstName,
        String lastName,
        String photoUrl,
        String cpf,
        String phoneNumber,
        Integer roleId,
        String roleName,
        AddressResponse address
) {}
