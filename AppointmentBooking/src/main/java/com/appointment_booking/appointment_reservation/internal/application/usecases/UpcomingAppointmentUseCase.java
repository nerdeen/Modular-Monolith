package com.appointment_booking.appointment_reservation.internal.application.usecases;

import com.appointment_booking.appointment_reservation.internal.application.gateways.AppointmentGateway;
import com.appointment_booking.appointment_reservation.internal.infrastructure.Mapper;
import com.appointment_booking.shared.dto.AppointmentResDTO;
import com.appointment_booking.shared.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpcomingAppointmentUseCase {
    AppointmentGateway appointmentGateway;

    public UpcomingAppointmentUseCase(AppointmentGateway appointmentGateway) {
        this.appointmentGateway = appointmentGateway;
    }

    public List<AppointmentResDTO> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception{
        List<AppointmentResDTO> appointmentResDTOS= appointmentGateway
                .getUpcomingScheduledAppointmentsByDoctorId(doctorId)
                .stream()
                .map(Mapper::toAppointmentResDto)
                .toList();
        if(appointmentResDTOS.isEmpty()){
            throw new BusinessException("No scheduled appointments found for doctor id " + doctorId);
        }
        return appointmentResDTOS;
    }
}
