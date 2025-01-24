package com.appointment_booking.appointment_reservation.internal.domain.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SlotsResDTO(String id, String time,boolean isReserved, double cost) {
}