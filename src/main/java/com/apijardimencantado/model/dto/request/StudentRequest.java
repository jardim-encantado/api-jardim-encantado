package com.apijardimencantado.model.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record StudentRequest(
        @NotBlank
        @Pattern(
                regexp = "\\d{11}",
                message = "CPF deve conter 11 dígitos"
        )
        String cpf
) {}