package com.appointment_booking.appointment_reservation.internal.application.serviceImpl;

import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.SlotsRepo;
import com.appointment_booking.appointment_reservation.internal.domain.service.SlotsService;
import com.appointment_booking.doctor_availability.internal.entity.SlotEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SlotsServiceImpl implements SlotsService {
    SlotsRepo slotsRepo;
    @Override
    public List<SlotsResDTO> viewSlots() {
            LocalDateTime oneHourLater = LocalDateTime.now().plusHours(1);
            List<SlotEntity>  slots =slotsRepo.findAvailableSlotsAfter(oneHourLater);
            List<SlotsResDTO> slotsResDTOs = new ArrayList<>();
            for (SlotEntity slotEntity : slots) {
                SlotsResDTO slot=new SlotsResDTO(slotEntity.getId(),slotEntity.getFormattedTime(),slotEntity.isReserved(),slotEntity.getCost());
                slotsResDTOs.add(slot);
            }
            return slotsResDTOs;
    }
}
