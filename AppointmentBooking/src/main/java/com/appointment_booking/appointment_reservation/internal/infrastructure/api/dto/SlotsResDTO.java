package com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto;

import lombok.Builder;

@Builder
public record SlotsResDTO(String id, String time, double cost) {
}