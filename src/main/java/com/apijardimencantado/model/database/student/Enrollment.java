package com.apijardimencantado.model.database.student;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long id;

    @Builder.Default
    @Convert(converter = EnrollmentStatus.Convert.class)
    private EnrollmentStatus status = EnrollmentStatus.PRE_ENROLLMENT;

    private LocalDateTime enrollment_date;

    @CreationTimestamp
    private LocalDateTime create_date;
    @UpdateTimestamp
    private LocalDateTime update_date;

}
