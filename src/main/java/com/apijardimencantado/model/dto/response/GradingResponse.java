package com.apijardimencantado.model.dto.response;

import com.apijardimencantado.model.database.Teacher;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GradingResponse(
        Long gradingId,
        StudentResponse student,
        StudySubjectResponse subject,
        String subjectName,
        BigDecimal grade,
        String observations,
        LocalDateTime gradingDate,
        LocalDateTime updateDate,
        Integer bimonthly,
        TeacherResponse givenBy
) {
}