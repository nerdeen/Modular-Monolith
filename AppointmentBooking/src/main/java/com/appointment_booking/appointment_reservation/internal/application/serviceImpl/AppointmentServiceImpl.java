package com.appointment_booking.appointment_reservation.internal.application.serviceImpl;

import com.appointment_booking.appointment_confirmation.NotificationApi;
import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.AppointmentRepo;
import com.appointment_booking.appointment_reservation.internal.domain.repo.SlotsRepo;
import com.appointment_booking.appointment_reservation.internal.domain.service.AppointmentService;
import com.appointment_booking.appointment_reservation.internal.infrastructure.entity.AppointmentEntity;
import com.appointment_booking.doctor_availability.internal.entity.SlotEntity;

import java.time.LocalTime;

public class AppointmentServiceImpl implements AppointmentService {
    AppointmentRepo appointmentRepo;
    SlotsRepo slotsRepo;
    NotificationApi notificationApi;
    @Override
    public void bookAppointment(AppointmentReqDTO appointmentReqDTO) throws Exception{
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setId(appointmentReqDTO.id());
        appointmentEntity.setSlotId(appointmentReqDTO.slotId());
        appointmentEntity.setPatientId(appointmentReqDTO.patientId());
        appointmentEntity.setPatientName(appointmentReqDTO.patientName());
        LocalTime currentTime = LocalTime.now();
        appointmentEntity.setReservedAt(currentTime);
        appointmentRepo.save(appointmentEntity);

        slotsRepo.markSlotAsReserved(appointmentEntity.getSlotId());

        SlotEntity slot=slotsRepo.findById(appointmentEntity.getSlotId()).orElse(null);
        notificationApi.notifyDoctor(slot.getDoctorName(),appointmentReqDTO.patientName());
        notificationApi.notifyPatient(slot.getDoctorName(),appointmentReqDTO.patientName());

    }
}
