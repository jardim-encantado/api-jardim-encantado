package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByGroup_GroupId(Long groupId);

}
