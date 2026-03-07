package com.apijardimencantado.repository;

import com.apijardimencantado.model.database.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String cpf);
    Person findByCpfAndPassword(String cpf, String password);

    @Query(
            value = """
        SELECT create_person(
            :firstName,
            :lastName,
            :email,
            :cpf,
            :phoneNumber,
            :password,
            :roleId
        )
    """,
            nativeQuery = true
    )
    Long createPerson(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("cpf") String cpf,
            @Param("phoneNumber") String phoneNumber,
            @Param("password") String password,
            @Param("roleId") Integer roleId
    );
}
