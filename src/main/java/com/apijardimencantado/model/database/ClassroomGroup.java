package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "classroom_group")
@Data
public class ClassroomGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;
    private String name;
    private String series;

    @OneToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroomId;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacherId;

}
