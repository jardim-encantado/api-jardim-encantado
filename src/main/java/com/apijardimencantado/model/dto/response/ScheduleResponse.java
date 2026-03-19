package com.apijardimencantado.model.dto.response;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public record ScheduleResponse(
     Long scheduleId,
     Long groupId,
     String groupName,
     LocalTime startTime,
     LocalTime endTime,
     List<ScheduleItemResponse> items,
     LocalDateTime createDate,
     LocalDateTime updateDate
) {
}
