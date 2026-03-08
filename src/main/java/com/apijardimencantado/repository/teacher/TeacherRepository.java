package com.apijardimencantado.repository.teacher;

import com.apijardimencantado.model.database.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findTeacherByPersonCpf (String cpf);
    boolean existsByPersonCpf (String cpf);
}

