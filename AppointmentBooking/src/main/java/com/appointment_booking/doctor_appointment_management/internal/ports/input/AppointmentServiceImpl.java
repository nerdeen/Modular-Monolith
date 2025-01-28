package com.appointment_booking.doctor_appointment_management.internal.ports.input;

import com.appointment_booking.doctor_appointment_management.internal.ports.output.AppointmentRepository;
import com.appointment_booking.shared.dto.AppointmentResDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<AppointmentResDTO> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception {
        return appointmentRepository.getUpcomingScheduledAppointmentsByDoctorId(doctorId);
    }

    @Override
    public void markAppointmentAsCompleted(String appointmentId) throws Exception{
        appointmentRepository.markAppointmentAsCompleted(appointmentId);
    }

    @Override
    public void markAppointmentAsCancelled(String appointmentId) throws Exception{
        appointmentRepository.markAppointmentAsCancelled(appointmentId);
    }

}
