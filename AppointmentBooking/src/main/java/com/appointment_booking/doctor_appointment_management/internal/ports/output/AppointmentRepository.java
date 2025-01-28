package com.appointment_booking.doctor_appointment_management.internal.ports.output;

import com.appointment_booking.shared.dto.AppointmentResDTO;

import java.util.List;

public interface AppointmentRepository {
    List<AppointmentResDTO> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception;

    void markAppointmentAsCompleted(String appointmentId) throws Exception;

    void markAppointmentAsCancelled(String appointmentId) throws Exception;
}
