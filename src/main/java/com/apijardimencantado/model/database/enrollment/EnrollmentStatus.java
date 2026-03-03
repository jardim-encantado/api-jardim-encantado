package com.apijardimencantado.model.database.enrollment;
import com.apijardimencantado.util.GenericEnumConverter;
import com.apijardimencantado.util.ValuedEnum;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum EnrollmentStatus implements ValuedEnum<Integer> {
    PRE_ENROLLMENT(1),
    ENROLLED(2),
    REJECTED(3);

    private final Integer id;

    @Override
    public Integer getValue() {
        return id;
    }

    @Converter(autoApply = true)
    public static class Convert extends GenericEnumConverter<EnrollmentStatus, Integer> {

        protected Convert(Class<EnrollmentStatus> enumClass) {
            super(enumClass);
        }
    }

    public record Adapter(EnrollmentStatus status) {
        public EnrollmentState toState() {
            return switch (status) {
                case PRE_ENROLLMENT -> new EnrollmentPreState();
                case ENROLLED -> new EnrollmentFinishedState();
                case REJECTED -> new EnrollmentRejectedState();
            };
        }
    }
}
