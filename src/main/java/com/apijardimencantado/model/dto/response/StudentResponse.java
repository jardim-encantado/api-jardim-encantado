package com.apijardimencantado.model.dto.response;

import com.apijardimencantado.model.database.enrollment.Enrollment;

public record StudentResponse(
        Long studentId,
        Long personId,
        String firstName,
        String lastName,
        String email,
        Enrollment enrollment
) { }
