package com.apijardimencantado.mapper;

import com.apijardimencantado.model.database.Schedule;
import com.apijardimencantado.model.database.ScheduleItem;
import com.apijardimencantado.model.database.Teacher;
import com.apijardimencantado.model.dto.request.ScheduleItemRequest;
import com.apijardimencantado.model.dto.response.ScheduleItemResponse;
import com.apijardimencantado.model.dto.request.ScheduleRequest;
import com.apijardimencantado.model.dto.response.ScheduleResponse;
import com.apijardimencantado.repository.classroom.ClassroomGroupRepository;
import com.apijardimencantado.repository.teacher.StudySubjectRepository;
import com.apijardimencantado.repository.teacher.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleMapper {

    private final ClassroomGroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final StudySubjectRepository subjectRepository;

    public Schedule toEntity(ScheduleRequest dto) {
        Schedule schedule = new Schedule();

        schedule.setGroup(
                groupRepository.findById(dto.groupId())
                        .orElseThrow(() -> new RuntimeException("Turma não encontrada"))
        );

        schedule.setStartTime(dto.startTime());
        schedule.setEndTime(dto.endTime());

        return schedule;
    }

    public ScheduleItem toItemEntity(ScheduleItemRequest dto) {
        ScheduleItem item = new ScheduleItem();

        item.setDayOfWeek(dto.dayOfWeek());
        item.setStartTime(dto.startTime());
        item.setEndTime(dto.endTime());

        item.setTeacher(
                teacherRepository.findById(dto.teacherId())
                        .orElseThrow(() -> new RuntimeException("Professor não encontrado"))
        );

        item.setSubject(
                subjectRepository.findById(dto.subjectId())
                        .orElseThrow(() -> new RuntimeException("Matéria não encontrada"))
        );

        return item;
    }

    public ScheduleResponse toResponse(Schedule schedule) {
        return new ScheduleResponse(
                schedule.getScheduleId(),
                schedule.getGroup().getGroupId(),
                schedule.getGroup().getName(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getItems().stream()
                        .map(this::toItemResponse)
                        .toList(),
                schedule.getCreateDate(),
                schedule.getUpdateDate()
        );
    }

    public ScheduleItemResponse toItemResponse(ScheduleItem item) {
        return new ScheduleItemResponse(
                item.getScheduleItemId(),
                item.getDayOfWeek(),
                getDayName(item.getDayOfWeek()),
                item.getStartTime(),
                item.getEndTime(),
                item.getSubject().getName(),
                item.getTeacher().getId()
        );
    }

    private String getTeacherName(Teacher teacher) {
        return teacher.getPerson().getFirstName() + " " +
                teacher.getPerson().getLastName();
    }

    private String getDayName(Integer day) {
        return switch (day) {
            case 1 -> "Segunda-feira";
            case 2 -> "Terça-feira";
            case 3 -> "Quarta-feira";
            case 4 -> "Quinta-feira";
            case 5 -> "Sexta-feira";
            default -> "Desconhecido";
        };
    }
}