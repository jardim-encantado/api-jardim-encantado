package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.ClassroomGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClassroomGroupRepository extends JpaRepository<ClassroomGroup, Long> {
}
