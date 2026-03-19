package com.apijardimencantado.model.dto.response;

import com.apijardimencantado.model.database.SchoolEventType;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;
public record SchoolEventResponse(

        Long eventId,

        String name,
        String description,

        LocalDateTime eventDate,

        PersonResponse createdBy,

        LocalDateTime createDate,

        LocalDateTime updateDate,

        SchoolEventTypeResponse eventTypeId,

        @Nullable
        StudentResponse student
) { }
