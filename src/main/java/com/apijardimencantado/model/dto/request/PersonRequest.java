package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record PersonRequest (
    @NotBlank(message = "Nome é obrigatório")
    String firstName,

    @NotBlank(message = "Sobrenome é obrigatório")
    String lastName,

    @NotBlank
    @Pattern(
            regexp = "\\d{11}",
            message = "CPF deve conter 11 dígitos"
    )
    String cpf,

    @Email(message = "Email inválido")
    @NotBlank
    String email,

    @NotBlank
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    String password,

    String photoUrl,

    @NotBlank
    Long roleId,

    @NotBlank
    AddressRequest address
){}
