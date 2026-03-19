package com.apijardimencantado.model.dto;

import java.time.LocalTime;

public record ScheduleItemResponse(
      Long scheduleItemId,
      Integer dayOfWeek,
      String dayName,
      LocalTime startTime,
      LocalTime endTime,
      String subject,
      Long teacherId


) {
}
