package com.apijardimencantado.repository.grading;

import com.apijardimencantado.model.database.Grading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GradingRepository extends JpaRepository<Grading, Long> {

    List<Grading> findByStudent_Person_Id(Long studentId);

}
