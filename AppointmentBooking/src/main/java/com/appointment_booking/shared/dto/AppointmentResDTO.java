package com.appointment_booking.shared.dto;

import lombok.Builder;

@Builder
public record AppointmentResDTO(String id,String slotId,String patientId,String patientName,String time) {
}

