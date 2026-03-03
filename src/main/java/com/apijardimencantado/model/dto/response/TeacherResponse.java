package com.apijardimencantado.model.dto.response;

import java.util.List;

public record TeacherResponse(
    Long teacherId,
    Long personId,
    String firstName,
    String lastName,
    String email,
    List<TeacherSubjectResponse> subjects
) {}
