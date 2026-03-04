package com.apijardimencantado.model.dto.response;

public record ClassroomGroupResponse (
        Long group_id,
        String name,
        String series,
        Long classroom_id,
        Long teacher_id

) {}
