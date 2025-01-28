package com.appointment_booking.appointment_reservation.internal.application.usecases;

import com.appointment_booking.appointment_reservation.internal.application.gateways.SlotGateway;
import org.springframework.stereotype.Service;

@Service
public class DoctorIdValidUseCase {

    SlotGateway slotGateway;

    public DoctorIdValidUseCase(SlotGateway slotGateway) {
        this.slotGateway = slotGateway;
    }
    public boolean isDoctorIdExist(String doctorId){
        return slotGateway.doctorIdValidUseCase(doctorId);
    }
}
