package com.appointment_booking.doctor_appointment_management.internal.core.model;

import com.appointment_booking.shared.exception.BusinessException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentManagement {
    private final String id;
    private final String doctorId;
    private final String patientId;
    private AppointmentStatus status;
    private final LocalDateTime appointmentTime;

    public AppointmentManagement(String id, String doctorId, String patientId, AppointmentStatus status, LocalDateTime appointmentTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.status = status;
        this.appointmentTime = appointmentTime;
    }

    public void markAsCompleted() {
        if (status == AppointmentStatus.CANCELED) {
            throw new BusinessException("Cannot complete a canceled appointment.");
        }
        this.status = AppointmentStatus.COMPLETED;
    }

    public void cancelAppointment() {
        if (status == AppointmentStatus.COMPLETED) {
            throw new BusinessException("Cannot cancel a completed appointment.");
        }
        this.status = AppointmentStatus.CANCELED;
    }

    public enum AppointmentStatus {
        SCHEDULED, COMPLETED, CANCELED
    }
}
