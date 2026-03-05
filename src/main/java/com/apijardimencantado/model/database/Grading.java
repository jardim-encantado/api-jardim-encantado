package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "grading")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Grading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradingId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private StudySubject subject;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal grade;

    private String observations;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime gradingDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn
    private Teacher givenByTeacherId;
}
