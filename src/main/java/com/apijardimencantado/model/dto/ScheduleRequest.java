package com.apijardimencantado.model.dto;

import java.time.LocalTime;
import java.util.List;

public record ScheduleRequest(
        Long groupId,
        LocalTime startTime,
        LocalTime endTime,
        List<ScheduleItemRequest> items
) {
}


