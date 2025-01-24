package com.appointment_booking.appointment_reservation.internal.domain.repo;

import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;

import java.util.List;

public interface SlotsRepo {
    public List<SlotsResDTO> viewAvailableSlots();
}
