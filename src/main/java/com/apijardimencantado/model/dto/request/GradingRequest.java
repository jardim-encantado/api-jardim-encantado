package com.apijardimencantado.model.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record GradingRequest(
    @NotNull
    Long studentId,

    @NotNull
    Long subjectId,

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("10.0")
    BigDecimal grade,

    String observations,

    @NotNull
    Long givenByTeacherId
) {}