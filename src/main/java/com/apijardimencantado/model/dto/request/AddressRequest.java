package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(

        @NotBlank(message = "Rua é obrigatória")
        String street,

        @NotBlank(message = "Número é obrigatório")
        String streetNumber,

        @NotBlank(message = "CEP é obrigatório")
        String cep,

        String complement,

        @NotBlank(message = "Cidade é obrigatória")
        String city,

        @NotBlank(message = "Estado é obrigatório")
        String state

) {}
