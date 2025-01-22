package com.appointment_booking.appointment_reservation.internal.domain.repo;

import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.infrastructure.entity.SlotEntity;

public interface AppointmentRepo {
    public void bookAppointment(AppointmentReqDTO appointmentReqDTO);

}
