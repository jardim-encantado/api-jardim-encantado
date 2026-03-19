package com.apijardimencantado.model.dto;

import java.time.LocalTime;
import java.util.List;

public record ScheduleRequestDto(
        Long groupId,
        LocalTime startTime,
        LocalTime endTime,
        List<ScheduleItemRequestDto> items
) {
}


