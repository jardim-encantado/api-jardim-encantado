package com.apijardimencantado.model.database;

import com.apijardimencantado.model.database.student.Student;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "guardian")
@Data
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guardian_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @OneToMany
    @JoinTable(
        name = "student_guardian",
        joinColumns = @JoinColumn(name = "guardian_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;
}
