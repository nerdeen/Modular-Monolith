package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.application.gateways.AppointmentGateway;
import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentRepo implements AppointmentGateway {

    IAppointmentRepo repository;

    public AppointmentRepo(IAppointmentRepo repository) {
        this.repository = repository;
    }

    @Override
    public AppointmentEntity addAppointment(AppointmentEntity appointment) {
        return repository.save(appointment);
    }

    @Override
    public List<AppointmentEntity> getUpcomingScheduledAppointmentsByDoctorId(String doctorId){
        return repository.getUpcomingScheduledAppointmentsByDoctorId(doctorId);
    }

    @Override
    @Transactional
    public void updateAppointment(AppointmentEntity appointmentEntity) throws Exception {
        repository.save(appointmentEntity);
    }

    @Override
    public Optional<AppointmentEntity> findAppointmentBySlotId(String slotId) throws Exception {
        return repository.findBySlotId(slotId);
    }

    @Override
    public Optional<AppointmentEntity> findAppointmentById(String appointmentId) throws Exception {
        return repository.findById(appointmentId);
    }

    @Override
    public void releaseSlotBySlotId(String slotId) throws Exception {
        repository.releaseSlotBySlotId(slotId);
    }

    @Override
    @Transactional
    public void deleteAppointment(AppointmentEntity appointment) throws Exception {
        repository.delete(appointment);
    }

}
