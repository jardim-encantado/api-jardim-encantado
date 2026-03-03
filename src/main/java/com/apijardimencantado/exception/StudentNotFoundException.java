package com.apijardimencantado.exception;

import jakarta.persistence.EntityNotFoundException;

public class StudentNotFoundException extends EntityNotFoundException {
    public StudentNotFoundException(Long studentId) {
        super(String.format("Student with id '%d' not found", studentId));
    }
}
