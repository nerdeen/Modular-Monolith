package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.SlotsRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SlotsRepoImpl implements SlotsRepo {


    @Override
    public List<SlotsResDTO> viewAvailableSlots() {
        return List.of();
    }
}
