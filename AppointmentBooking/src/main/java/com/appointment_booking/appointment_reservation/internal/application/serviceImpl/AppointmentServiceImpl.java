package com.appointment_booking.appointment_reservation.internal.application.serviceImpl;

import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.AppointmentRepo;
import com.appointment_booking.appointment_reservation.internal.domain.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepo appointmentRepo;
    @Override
    public void bookAppointment(AppointmentReqDTO appointmentReqDTO) {
        appointmentRepo.bookAppointment(appointmentReqDTO);
    }
}
