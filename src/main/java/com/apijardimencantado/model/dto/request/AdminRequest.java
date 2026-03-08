package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotNull;

public record AdminRequest(
        @NotNull(message = "Person ID is required")
        Long personId
) {}