package com.appointment_booking.appointment_reservation.internal.application.usecases;

import com.appointment_booking.appointment_reservation.internal.application.gateways.SlotGateway;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.SlotsResDTO;
import com.appointment_booking.shared.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewAllAvailableSlotsUseCase {
    SlotGateway slotGateway;

    public ViewAllAvailableSlotsUseCase(SlotGateway slotGateway) {
        this.slotGateway = slotGateway;
    }

    public List<SlotsResDTO> viewSlots() {
        List<SlotsResDTO> availableSlots = slotGateway.findAllByReservedIsAndTimeAfter();
        if(null == availableSlots || availableSlots.isEmpty()){
            throw new BusinessException("No available slots found");
        }
        return availableSlots;
    }
}
