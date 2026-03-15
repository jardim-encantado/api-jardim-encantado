package com.apijardimencantado.repository.classroom;

import com.apijardimencantado.model.database.ClassroomGroupStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomGroupStudentRepository extends JpaRepository<ClassroomGroupStudent, Integer> {
}
