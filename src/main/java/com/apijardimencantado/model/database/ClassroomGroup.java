package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "classroom_group")
@Data
public class ClassroomGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;
    private String name;
    private String series;

    private Long classroom_id;
    private Long teacher_id;
}
