package com.appointment_booking.appointment_reservation.shared;

import com.appointment_booking.appointment_reservation.internal.application.usecases.DoctorIdValidUseCase;
import com.appointment_booking.appointment_reservation.internal.application.usecases.UpcomingAppointmentUseCase;
import com.appointment_booking.appointment_reservation.internal.application.usecases.UpdateAppointmentStatusUseCase;
import com.appointment_booking.shared.dto.AppointmentResDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentReservationFacade implements IAppointmentReservationFacade {

    DoctorIdValidUseCase doctorIdValidUseCase;
    UpdateAppointmentStatusUseCase updateAppointmentStatusUseCase;
    UpcomingAppointmentUseCase upcomingAppointmentUseCase;

    public AppointmentReservationFacade(DoctorIdValidUseCase doctorIdValidUseCase
            , UpdateAppointmentStatusUseCase updateAppointmentStatusUseCase
            , UpcomingAppointmentUseCase upcomingAppointmentUseCase) {
        this.doctorIdValidUseCase = doctorIdValidUseCase;
        this.updateAppointmentStatusUseCase = updateAppointmentStatusUseCase;
        this.upcomingAppointmentUseCase = upcomingAppointmentUseCase;
    }

    @Override
    public List<AppointmentResDTO> getUpcomingScheduledAppointmentsByDoctorId(String doctorId) throws Exception{
       return upcomingAppointmentUseCase
                .getUpcomingScheduledAppointmentsByDoctorId(doctorId);
    }

    @Override
    public void markAppointmentAsCompleted(String appointmentId) throws Exception{
        updateAppointmentStatusUseCase.markAppointmentAsCompleted(appointmentId);
    }

    @Override
    public void markAppointmentAsCancelled(String appointmentId)throws Exception{
        updateAppointmentStatusUseCase.markAppointmentAsCancelled(appointmentId);
    }

    @Override
    public boolean isValidDoctorId(String doctorId) throws Exception {
        return doctorIdValidUseCase.isDoctorIdExist(doctorId);
    }

}
