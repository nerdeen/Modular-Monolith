package com.appointment_booking.doctor_availability.internal.dto;

import lombok.Builder;

@Builder
public record SlotResDTO(String id, String time,boolean isReserved, double cost) {
}
