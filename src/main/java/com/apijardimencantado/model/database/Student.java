package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
}
