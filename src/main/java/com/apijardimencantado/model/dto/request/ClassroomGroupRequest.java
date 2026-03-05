package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClassroomGroupRequest(

        @NotBlank(message = "O nome é obrigatório")
        String name,

        @NotBlank(message = "A série é obirgatório")
        String series,

        @NotNull(message = "O identificador da sala é obrigatório")
        ClassroomRequest classroomId,

        @NotNull(message = "O cpf do professor é obrigatório")
        TeacherRequest teacherId

) {}
