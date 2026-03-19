package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.ScheduleItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleItemRepository extends JpaRepository<ScheduleItem, Long> {
    //List<ScheduleItem> findBySchedule_ScheduleId(Long scheduleId);
    List<ScheduleItem> findByTeacher_Id(Long teacherId);
    void deleteAllBySchedule_ScheduleId(Long scheduleId);

}
