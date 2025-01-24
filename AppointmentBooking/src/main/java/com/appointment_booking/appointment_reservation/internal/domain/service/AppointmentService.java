package com.appointment_booking.appointment_reservation.internal.domain.service;

import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;

public interface AppointmentService {
    public void bookAppointment(AppointmentReqDTO appointmentReqDTO) throws Exception;
}
