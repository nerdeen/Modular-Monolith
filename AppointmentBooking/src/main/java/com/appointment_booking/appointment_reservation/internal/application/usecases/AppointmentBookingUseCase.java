package com.appointment_booking.appointment_reservation.internal.application.usecases;

import com.appointment_booking.appointment_confirmation.shared.NotificationApi;
import com.appointment_booking.appointment_reservation.internal.application.gateways.AppointmentGateway;
import com.appointment_booking.appointment_reservation.internal.application.gateways.SlotGateway;
import com.appointment_booking.appointment_reservation.internal.domain.Appointment;
import com.appointment_booking.appointment_reservation.internal.infrastructure.Mapper;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.AppointmentReqDTO;
import com.appointment_booking.doctor_availability.shared.sharedDB.db.SlotEntity;
import com.appointment_booking.shared.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class AppointmentBookingUseCase {
    AppointmentGateway appointmentGateway;
    SlotGateway slotGateway;
    NotificationApi notificationApi;

    @Transactional
    public String bookAppointment(AppointmentReqDTO appointmentReqDTO) throws Exception{

        SlotEntity slotEntity = slotGateway.findBySlotId(appointmentReqDTO.slotId())
                  .orElseThrow(() -> new NotFoundException("Slot not found with ID: " + appointmentReqDTO.slotId()));

        Appointment appointment= Mapper.toAppointment(appointmentReqDTO);
        appointment.setAppointmentTime(slotEntity.getTime());
        appointment.validate();

        slotEntity.setReserved(true);

        slotGateway.updateSlot(slotEntity);
        String appointmentId= appointmentGateway.addAppointment(Mapper.toAppointment(appointment)).getId();
        notificationApi.notifyDoctor(slotEntity.getDoctorName(),appointmentReqDTO.patientName());
        notificationApi.notifyPatient(slotEntity.getDoctorName(),appointmentReqDTO.patientName());
        return appointmentId;
    }
}
