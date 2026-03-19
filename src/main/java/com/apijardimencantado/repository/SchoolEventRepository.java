package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.SchoolEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolEventRepository extends JpaRepository<SchoolEvent, Long> {
    List<SchoolEvent> findByStudent_Id(Long studentId);
}
