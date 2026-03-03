package com.apijardimencantado.model.database.enrollment;

public interface EnrollmentState {
    EnrollmentStatus getStatus();

    EnrollmentState finish() throws IllegalStateException;

    EnrollmentState reject() throws IllegalStateException;
}
