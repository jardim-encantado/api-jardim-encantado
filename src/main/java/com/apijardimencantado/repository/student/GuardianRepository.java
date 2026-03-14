package com.apijardimencantado.repository.student;

import com.apijardimencantado.model.database.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    Optional<Guardian> findByPerson_Cpf(String cpf);
}
