package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.AppointmentRepo;
import com.appointment_booking.appointment_reservation.internal.infrastructure.entity.SlotEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepoImpl implements AppointmentRepo {

    @Override
    public void bookAppointment(AppointmentReqDTO appointmentReqDTO) {
        SlotEntity slot=new SlotEntity();
    }
}
