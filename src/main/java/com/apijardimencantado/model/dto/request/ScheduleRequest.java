package com.apijardimencantado.model.dto.request;

import java.time.LocalTime;
import java.util.List;

public record ScheduleRequest(
        Long groupId,
        LocalTime startTime,
        LocalTime endTime,
        List<ScheduleItemRequest> items
) {
}


