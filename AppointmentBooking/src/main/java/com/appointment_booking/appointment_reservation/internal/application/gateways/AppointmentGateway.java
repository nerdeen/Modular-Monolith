package com.appointment_booking.appointment_reservation.internal.application.gateways;

import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;

public interface AppointmentGateway {
    AppointmentEntity addAppointment(AppointmentEntity appointment);
}
