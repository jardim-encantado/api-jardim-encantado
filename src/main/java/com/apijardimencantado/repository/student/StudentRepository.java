package com.apijardimencantado.repository.student;

import com.apijardimencantado.model.database.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s JOIN s.person p WHERE p.cpf = :cpf")
    Student findByCpf(String cpf);
}
