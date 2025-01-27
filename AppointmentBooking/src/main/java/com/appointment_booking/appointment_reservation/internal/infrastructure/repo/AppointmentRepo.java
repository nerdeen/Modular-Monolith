package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.application.gateways.AppointmentGateway;
import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepo implements AppointmentGateway {

    JpaRepository<AppointmentEntity, String> repository;

    @Override
    public AppointmentEntity addAppointment(AppointmentEntity appointment) {
        return repository.save(appointment);
    }
}
