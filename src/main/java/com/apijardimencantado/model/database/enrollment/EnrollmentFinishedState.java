package com.apijardimencantado.model.database.enrollment;

public class EnrollmentFinishedState implements EnrollmentState {
    @Override
    public EnrollmentStatus getStatus() {
        return EnrollmentStatus.ENROLLED;
    }

    @Override
    public EnrollmentState finish() {
        throw new IllegalStateException("Student already enrolled, cannot finish again");
    }

    @Override
    public EnrollmentState reject() {
        throw new IllegalStateException("Student already enrolled, cannot reject");
    }
}
