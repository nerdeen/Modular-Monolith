package com.appointment_booking.appointment_reservation.internal.application.usecases;

import com.appointment_booking.appointment_reservation.internal.application.gateways.AppointmentGateway;
import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import com.appointment_booking.shared.dto.AppointmentStatus;
import com.appointment_booking.shared.exception.BusinessException;
import com.appointment_booking.shared.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateAppointmentStatusUseCase {
    AppointmentGateway appointmentGateway;

    public UpdateAppointmentStatusUseCase(AppointmentGateway appointmentGateway) {
        this.appointmentGateway = appointmentGateway;
    }


    public void markAppointmentAsCompleted(String appointmentId) throws Exception{
        AppointmentEntity appointmentEntity = getAppointment(appointmentId);
        if (AppointmentStatus.CANCELED.name().equals(appointmentEntity.getStatus())){
            throw new BusinessException("can't complete cancelled appointment...");
        }
        appointmentEntity.setStatus(AppointmentStatus.COMPLETED.name());
        appointmentGateway.updateAppointment(appointmentEntity);
    }

    public void markAppointmentAsCancelled(String appointmentId) throws Exception{
        AppointmentEntity appointmentEntity = getAppointment(appointmentId);
        if (AppointmentStatus.COMPLETED.name().equals(appointmentEntity.getStatus())){
            throw new BusinessException("can't cancel completed appointment...");
        }
        if(appointmentEntity.getTime().isAfter(LocalDateTime.now())){
            appointmentGateway.deleteAppointment(appointmentEntity);
            appointmentGateway.releaseSlotBySlotId(appointmentEntity.getSlotId());
        }else{
            appointmentEntity.setStatus(AppointmentStatus.CANCELED.name());
            appointmentGateway.updateAppointment(appointmentEntity);
        }
    }

    public AppointmentEntity getAppointment(String appointmentId) throws Exception{
        return appointmentGateway.
                findAppointmentById(appointmentId)
                .orElseThrow(()->new NotFoundException("Appointment not found with ID: " + appointmentId));
    }
}
