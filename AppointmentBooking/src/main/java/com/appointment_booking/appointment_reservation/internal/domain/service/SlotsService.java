package com.appointment_booking.appointment_reservation.internal.domain.service;

import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;

import java.util.List;

public interface SlotsService {
    public List<SlotsResDTO> viewSlots();
}
