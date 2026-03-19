package com.apijardimencantado.model.dto.request;

import java.time.LocalTime;

public record ScheduleItemRequest(
         Integer dayOfWeek,
         LocalTime startTime,
         LocalTime endTime,
         Long subjectId,
         Long teacherId
){}
