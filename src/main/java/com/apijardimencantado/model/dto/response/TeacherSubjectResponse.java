package com.apijardimencantado.model.dto.response;

public record TeacherSubjectResponse(
        Long teacherSubjectId,
        Long teacherId,
        String teacherName,
        Long subjectId,
        String subjectName
) {}
