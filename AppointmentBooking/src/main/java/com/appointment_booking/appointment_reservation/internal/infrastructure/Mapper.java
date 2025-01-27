package com.appointment_booking.appointment_reservation.internal.infrastructure;

import com.appointment_booking.appointment_reservation.internal.domain.Appointment;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.SlotsResDTO;
import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import com.appointment_booking.doctor_availability.shared.sharedDB.db.SlotEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Mapper {
    public static SlotsResDTO toSlotsResDTO(SlotEntity entity) {
        return new SlotsResDTO(
                entity.getId(),
                entity.getFormattedTime(),
                entity.getCost()
        );
    }

    public static Appointment toAppointment(AppointmentReqDTO reqDTO) {
        return new Appointment(reqDTO.slotId()
                , reqDTO.patientId()
                , reqDTO.patientName()
                , LocalDateTime.now());
    }

    public static AppointmentEntity toAppointment(Appointment appointment) {
        return new AppointmentEntity(UUID.randomUUID().toString()
                ,appointment.getSlotId()
                , appointment.getPatientId()
                , appointment.getPatientName()
                , appointment.getReservedAt());
    }
}
