package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record SchoolEventRequest (
         @NotBlank(message = "O título é obrigatório")
         String name,

         @NotBlank(message = "A descrição é obrigatória")
         String description,

         @NotBlank(message = "A data do evento é obrigatória")
         LocalDateTime eventDate,

         @NotBlank(message = "O criador da ocorrênica é obrigatório")
         String cpf,
         @NotBlank(message = "O tipo de ocorrência é obrigatório")
         Long eventTypeId
) {}
