package com.apijardimencantado.model.database.enrollment;

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

    private LocalDateTime enrollment_date;

    @CreationTimestamp
    private LocalDateTime create_date;
    @UpdateTimestamp
    private LocalDateTime update_date;

    @Builder.Default
    @Convert(converter = EnrollmentStatus.Convert.class)
    private EnrollmentStatus status = EnrollmentStatus.PRE_ENROLLMENT;

    @Transient
    private transient EnrollmentState state = null;

    private EnrollmentState getState() {
        return new EnrollmentStatus.Adapter(status).toState();
    }

    public void finish() {
        this.state = this.getState().finish();
        this.status = this.state.getStatus();
        this.enrollment_date = LocalDateTime.now();
    }

    public void reject() {
        this.state = this.getState().reject();
        this.status = this.state.getStatus();
    }
}
