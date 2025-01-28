package com.appointment_booking.appointment_reservation.internal.infrastructure;

import com.appointment_booking.appointment_reservation.internal.domain.Appointment;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.SlotsResDTO;
import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import com.appointment_booking.doctor_availability.shared.sharedDB.db.SlotEntity;
import com.appointment_booking.shared.dto.AppointmentResDTO;
import com.appointment_booking.shared.dto.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Mapper {
    public static SlotsResDTO toSlotsResDTO(SlotEntity entity) {
        return new SlotsResDTO(
                entity.getId(),
                entity.getFormattedTime(),
                entity.getDoctorName(),
                entity.getCost()
        );
    }

    public static Appointment toAppointmentEntity(AppointmentReqDTO reqDTO) {
        return new Appointment(reqDTO.slotId()
                , reqDTO.patientId()
                , reqDTO.patientName()
                , LocalDateTime.now());
    }

    public static AppointmentEntity toAppointmentEntity(Appointment appointment,LocalDateTime time) {
        return AppointmentEntity
                .builder()
                .id(UUID.randomUUID().toString())
                .slotId(appointment.getSlotId())
                .patientId(appointment.getPatientId())
                .patientName(appointment.getPatientName())
                .status(AppointmentStatus.SCHEDULED.name())
                .time(time)
                .build();
    }

    public static AppointmentResDTO toAppointmentResDto(AppointmentEntity appointment) {
        return AppointmentResDTO
                .builder()
                .id(appointment.getId())
                .slotId(appointment.getSlotId())
                .patientId(appointment.getPatientId())
                .patientName(appointment.getPatientName())
                .time(appointment.getFormattedTime())
                .build();
    }
}
