package com.apijardimencantado.model.dto.response;

public record StudentResponse(
        Long studentId,
        Long personId,
        String firstName,
        String lastName,
        String email
) { }
