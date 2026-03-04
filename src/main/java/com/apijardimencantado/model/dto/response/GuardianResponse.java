package com.apijardimencantado.model.dto.response;

import java.util.List;

public record GuardianResponse(
        Long guardianId,
        Long personId,
        String firstName,
        String lastName,
        String email,

        List<StudentResponse> students
) {

}
