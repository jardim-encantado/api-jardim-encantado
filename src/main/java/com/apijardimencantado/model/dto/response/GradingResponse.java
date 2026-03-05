package com.apijardimencantado.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GradingResponse(
        Long gradingId,
        Long studentId,
        Long subjectId,
        String subjectName,
        BigDecimal grade,
        String observations,
        LocalDateTime gradingDate,
        LocalDateTime updateDate,
        Long givenByTeacherId,
        String teacherName
) {
}