package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.SchoolEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolEventRepository extends JpaRepository<SchoolEvent, Long> {
    SchoolEvent findByStudent_Id(Long studentId);
}
