package com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto;

import lombok.Builder;

@Builder
public record AppointmentReqDTO(String slotId, String patientId, String patientName) {
}