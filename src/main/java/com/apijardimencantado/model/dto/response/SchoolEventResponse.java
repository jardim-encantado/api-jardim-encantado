package com.apijardimencantado.model.dto.response;

import com.apijardimencantado.model.database.SchoolEventType;
import java.time.LocalDateTime;
public record SchoolEventResponse(

        Long eventId,

        String name,
        String description,

        LocalDateTime eventDate,

        PersonResponse createdBy,

        LocalDateTime createDate,

        LocalDateTime updateDate,

        SchoolEventType eventTypeId
) { }
