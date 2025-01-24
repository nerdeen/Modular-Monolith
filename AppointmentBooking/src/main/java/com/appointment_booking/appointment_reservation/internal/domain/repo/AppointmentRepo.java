package com.appointment_booking.appointment_reservation.internal.domain.repo;

import com.appointment_booking.appointment_reservation.internal.infrastructure.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity, String> {

}
