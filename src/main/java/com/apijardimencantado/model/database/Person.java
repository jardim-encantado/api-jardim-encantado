package com.apijardimencantado.model.database;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;
    private String password;
    private String photoUrl;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "person_role_id", nullable = false)
    private Role role;

    @CreationTimestamp
    private LocalDateTime create_date;
    @UpdateTimestamp
    private LocalDateTime update_date;

}
