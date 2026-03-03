package com.apijardimencantado.model.database.enrollment;

public class EnrollmentRejectedState implements EnrollmentState {
    @Override
    public EnrollmentStatus getStatus() {
        return EnrollmentStatus.REJECTED;
    }

    @Override
    public EnrollmentState finish() {
        throw new IllegalStateException("Enrollment already rejected, cannot finish");
    }

    @Override
    public EnrollmentState reject() {
        throw new IllegalStateException("Enrollment already rejected");
    }
}
