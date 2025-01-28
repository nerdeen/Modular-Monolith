package com.appointment_booking.doctor_appointment_management.internal.adapter;

import com.appointment_booking.appointment_reservation.shared.IAppointmentReservationFacade;
import com.appointment_booking.doctor_appointment_management.internal.ports.output.AppointmentRepository;
import com.appointment_booking.shared.dto.AppointmentResDTO;
import com.appointment_booking.shared.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    IAppointmentReservationFacade iAppointmentReservationFacade;

    public AppointmentRepositoryImpl(IAppointmentReservationFacade iAppointmentReservationFacade) {
        this.iAppointmentReservationFacade = iAppointmentReservationFacade;
    }

    @Override
    public List<AppointmentResDTO> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception {
        boolean isExist=iAppointmentReservationFacade.isValidDoctorId(doctorId);
        if(!isExist){
            throw new NotFoundException("Doctor not found with id "+doctorId);
        }
        return iAppointmentReservationFacade.getUpcomingScheduledAppointmentsByDoctorId(doctorId);
    }
    @Override
    public void markAppointmentAsCompleted(String appointmentId) throws Exception {
        iAppointmentReservationFacade.markAppointmentAsCompleted(appointmentId);
    }
    @Override
    public void markAppointmentAsCancelled(String appointmentId)throws Exception{
        iAppointmentReservationFacade.markAppointmentAsCancelled(appointmentId);
    }
}
