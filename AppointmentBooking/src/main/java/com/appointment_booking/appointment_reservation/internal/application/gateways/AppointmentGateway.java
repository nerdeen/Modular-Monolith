package com.appointment_booking.appointment_reservation.internal.application.gateways;

import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentGateway {
    AppointmentEntity addAppointment(AppointmentEntity appointment);
    List<AppointmentEntity> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception;
    void updateAppointment(AppointmentEntity appointmentEntity) throws Exception;
    Optional<AppointmentEntity> findAppointmentBySlotId(String slotId) throws Exception;
    Optional<AppointmentEntity> findAppointmentById(String appointmentId) throws Exception;
    void releaseSlotBySlotId(String slotId) throws Exception;
    void deleteAppointment(AppointmentEntity appointment) throws Exception;

}
