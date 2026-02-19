package com.apijardimencantado.model.dto.response;

public record PersonResponse(
        Long id,
        String firstName,
        String photoUrl,
        String roleName
) {}
