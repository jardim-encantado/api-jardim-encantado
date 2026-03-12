package com.apijardimencantado.model.dto.response;

public record AdminResponse(
        Long adminId,
        Long personId,
        String photoUrl,
        String cpf,
        String phoneNumber
) {}