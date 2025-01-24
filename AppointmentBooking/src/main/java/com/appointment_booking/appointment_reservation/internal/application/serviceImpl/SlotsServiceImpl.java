package com.appointment_booking.appointment_reservation.internal.application.serviceImpl;

import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.SlotsRepo;
import com.appointment_booking.appointment_reservation.internal.domain.service.SlotsService;

import java.util.List;

public class SlotsServiceImpl implements SlotsService {
    SlotsRepo slotsRepo;
    @Override
    public List<SlotsResDTO> viewSlots() {
        return slotsRepo.viewAvailableSlots();
    }
}
