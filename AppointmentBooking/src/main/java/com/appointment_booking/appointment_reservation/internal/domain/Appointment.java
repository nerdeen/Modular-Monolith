package com.appointment_booking.appointment_reservation.internal.domain;

import com.appointment_booking.shared.exception.BusinessException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Appointment {
    private String slotId;
    private String patientId;
    private String patientName;
    private LocalDateTime appointmentTime;
    private LocalDateTime reservedAt;

    public Appointment(String slotId, String patientId, String patientName, LocalDateTime reservedAt) {
        this.slotId = slotId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
    }

    public void validate() {
        if (appointmentTime.isBefore(LocalDateTime.now())) {
            throw new BusinessException("Appointment time cannot be in the past.");
        }

        if (patientName == null || patientName.isBlank()) {
            throw new BusinessException("Patient name cannot be empty.");
        }
    }
}
