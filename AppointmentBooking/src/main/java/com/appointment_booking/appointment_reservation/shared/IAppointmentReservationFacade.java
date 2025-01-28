package com.appointment_booking.appointment_reservation.shared;

import com.appointment_booking.shared.dto.AppointmentResDTO;

import java.util.List;

public interface IAppointmentReservationFacade {
    List<AppointmentResDTO> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception;
    void markAppointmentAsCompleted(String appointmentId) throws Exception;
    void markAppointmentAsCancelled(String appointmentId) throws Exception ;
    boolean isValidDoctorId(String doctorId) throws Exception;
}
