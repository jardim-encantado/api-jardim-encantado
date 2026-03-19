package com.apijardimencantado.service;

import com.apijardimencantado.mapper.ScheduleMapper;
import com.apijardimencantado.model.database.ClassroomGroup;
import com.apijardimencantado.model.database.ClassroomGroupStudent;
import com.apijardimencantado.model.database.Schedule;
import com.apijardimencantado.model.database.ScheduleItem;
import com.apijardimencantado.model.dto.ScheduleItemResponse;
import com.apijardimencantado.model.dto.ScheduleRequest;
import com.apijardimencantado.model.dto.ScheduleResponse;
import com.apijardimencantado.repository.ScheduleItemRepository;
import com.apijardimencantado.repository.ScheduleRepository;
import com.apijardimencantado.repository.classroom.ClassroomGroupRepository;
import com.apijardimencantado.repository.classroom.ClassroomGroupStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleItemRepository itemRepository;

    private final ClassroomGroupRepository groupRepository;

    private final ClassroomGroupStudentRepository classroomGroupStudentRepository;
    private final ScheduleMapper mapper;

    public ScheduleResponse create(ScheduleRequest dto) {
        Schedule schedule = mapper.toEntity(dto);
        scheduleRepository.save(schedule);

        List<ScheduleItem> items = dto.items().stream().map(itemDTO -> {
            ScheduleItem item = mapper.toItemEntity(itemDTO);
            item.setSchedule(schedule);
            return item;
        }).toList();

        itemRepository.saveAll(items);
        schedule.setItems(items);

        return mapper.toResponse(schedule);
    }

    public ScheduleResponse getByGroup(Long groupId) {
        Schedule schedule = scheduleRepository.findByGroup_GroupId(groupId)
                .orElseThrow(() -> new RuntimeException("Grade não encontrada"));

        return mapper.toResponse(schedule);
    }

    public ScheduleResponse getByStudent(Long studentId) {

        ClassroomGroupStudent relation = classroomGroupStudentRepository
                .findByStudent_Id(studentId)
                .orElseThrow(() -> new RuntimeException("Aluno não está em nenhuma turma"));

        ClassroomGroup group = relation.getClassroomGroup();

        Schedule schedule = scheduleRepository
                .findByGroup_GroupId(group.getGroupId())
                .orElseThrow(() -> new RuntimeException("Grade não encontrada"));

        return mapper.toResponse(schedule);
    }

    public List<ScheduleItemResponse> getByTeacher(Long teacherId) {
        List<ScheduleItem> items = itemRepository.findByTeacher_Id(teacherId);
        return items.stream()
                .map(mapper::toItemResponse)
                .toList();
    }



    public ScheduleResponse update(Long id, ScheduleRequest dto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade não encontrada"));

        schedule.setStartTime(dto.startTime());
        schedule.setEndTime(dto.endTime());

        schedule.setGroup(
                groupRepository.findById(dto.groupId())
                        .orElseThrow(() -> new RuntimeException("Turma não encontrada"))
        );

        itemRepository.deleteAllBySchedule_ScheduleId(schedule.getScheduleId());

        List<ScheduleItem> newItems = dto.items().stream().map(itemDTO -> {
            ScheduleItem item = mapper.toItemEntity(itemDTO);
            item.setSchedule(schedule);
            return item;
        }).toList();

        itemRepository.saveAll(newItems);
        schedule.setItems(newItems);

        Schedule saved = scheduleRepository.save(schedule);

        return mapper.toResponse(saved);
    }

    public void delete(Long id) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grade não encontrada"));
        itemRepository.deleteAllBySchedule_ScheduleId(id);
        scheduleRepository.delete(schedule);
    }
}