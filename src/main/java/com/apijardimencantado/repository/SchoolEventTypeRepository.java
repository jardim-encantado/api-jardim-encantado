package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.SchoolEventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolEventTypeRepository extends JpaRepository<SchoolEventType, Long> {
}
