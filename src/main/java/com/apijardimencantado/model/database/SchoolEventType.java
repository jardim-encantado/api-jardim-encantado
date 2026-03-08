package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "school_event_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolEventType {

    @Id
    @Column(name = "event_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventTypeId;
    private String name;

}
