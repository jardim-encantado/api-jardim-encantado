package com.apijardimencantado.model.dto.response;

public record ClassroomGroupResponse (
        Long groupId,
        String name,
        String series,
        ClassroomResponse classroomId,
        TeacherResponse teacherId

) {}
