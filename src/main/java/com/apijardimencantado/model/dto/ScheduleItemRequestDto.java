package com.apijardimencantado.model.dto;

import java.time.LocalTime;

public record ScheduleItemRequestDto(
         Integer dayOfWeek,
         LocalTime startTime,
         LocalTime endTime,
         Long subjectId,
         Long teacherId
){}
