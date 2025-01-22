package com.appointment_booking.appointment_reservation.internal.domain.dto;

import lombok.Builder;

@Builder
public record AppointmentReqDTO(String id, String slotId, String patientId, String patientName,String reservedAt) {
}