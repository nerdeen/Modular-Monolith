package com.appointment_booking.doctor_availability.internal.dto;

import java.time.LocalDateTime;

public record SlotReqDTO(String doctorId, String doctorName, LocalDateTime time, double cost) {
}
