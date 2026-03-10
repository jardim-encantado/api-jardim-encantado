package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name = "school_event")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String name;
    private String description;

    private LocalDateTime eventDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Person createdBy;

    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private SchoolEventType eventTypeId;
}
