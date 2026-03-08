package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "classroom")
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Long classroomId;
    private String identifier;

}
