package com.appointment_booking.appointment_reservation.internal.application.gateways;

import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.SlotsResDTO;
import com.appointment_booking.doctor_availability.shared.sharedDB.db.SlotEntity;

import java.util.List;
import java.util.Optional;

public interface SlotGateway{
   List<SlotsResDTO> findAllByReservedIsAndTimeAfter();
   Optional<SlotEntity> findBySlotId(String slotId);
   void updateSlot(SlotEntity slotEntity);
}
