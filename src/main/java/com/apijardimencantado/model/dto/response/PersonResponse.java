package com.apijardimencantado.model.dto.response;

public record PersonResponse(
        Long id,
        String firstName,
        String lastName,
        String photoUrl,
        String roleName,
        AddressResponse address
) {}
