package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        @NotBlank(message = "O nome do cargo é obrigatório.")
        String name
) {}