package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest (
        @NotBlank(message = "O cpf é obrigatório")
        String cpf,
        @NotBlank(message = "A senha é obrigatória")
        String password

) {}
