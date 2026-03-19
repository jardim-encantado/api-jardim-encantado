package com.apijardimencantado.model.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record SchoolEventRequest (
         @NotBlank(message = "O título é obrigatório")
         String name,

         @NotBlank(message = "A descrição é obrigatória")
         String description,

         @NotNull(message = "A data do evento é obrigatória")
         LocalDateTime eventDate,

         @NotBlank(message = "O criador da ocorrênica é obrigatório")
         String cpf,

         @Nullable
         Long studentId,

         @NotNull(message = "O tipo de ocorrência é obrigatório")
         Long eventTypeId
) {}
