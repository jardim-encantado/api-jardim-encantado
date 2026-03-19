package com.apijardimencantado.model.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record ScheduleResponseDto(
     Long scheduleId,
     Long groupId,
     String groupName,
     LocalTime startTime,
     LocalTime endTime,
     List<ScheduleItemResponseDto> items,
     LocalDateTime createDate,
     LocalDateTime updateDate
) {
}
