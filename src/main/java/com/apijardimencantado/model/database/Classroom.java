package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "classroom")
@Data
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroom_id;
    private String identifier;
}
