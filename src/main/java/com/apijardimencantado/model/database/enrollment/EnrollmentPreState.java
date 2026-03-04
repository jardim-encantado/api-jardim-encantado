package com.apijardimencantado.model.database.enrollment;

public class EnrollmentPreState implements EnrollmentState {
    @Override
    public EnrollmentStatus getStatus() {
        return EnrollmentStatus.PRE_ENROLLMENT;
    }

    @Override
    public EnrollmentState finish() {
        return new EnrollmentFinishedState();
    }

    @Override
    public EnrollmentState reject() {
        return new EnrollmentRejectedState();
    }
}
