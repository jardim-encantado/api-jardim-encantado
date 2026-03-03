package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.TeacherSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject,Long> {
    List<TeacherSubject> findByTeacherId(Long teacherId);
}
