package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ClassroomRequest (
        @NotBlank(message = "O identificador é obrigatório")
        @Size(min = 7, max = 7)
        @Pattern(regexp = "^[A-Z]{3}-\\d{3}$")
        String identifier

) {}
