package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ClassroomGroupRequest(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "A série é obirgatório")
        String series,

        @NotBlank(message = "O classroom_id é obrigatório")
        Long classroom_id,

        @NotBlank(message = "O teacher_id é obrigatório")
        Long teacher_id

) {}
