package com.apijardimencantado.repository.classroom;

import com.apijardimencantado.model.database.ClassroomGroupStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomGroupStudentRepository extends JpaRepository<ClassroomGroupStudent, Integer> {
    Optional<ClassroomGroupStudent> findByStudent_Id(Long studentId);
}

