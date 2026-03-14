package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classroom_group_student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassroomGroupStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_group_student_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private ClassroomGroup classroomGroup;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}