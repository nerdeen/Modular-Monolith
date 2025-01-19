package com.appointment_booking.doctor_availability.internal.dto;

import com.appointment_booking.doctor_availability.internal.entity.SlotEntity;

import java.util.UUID;

public class Mapper {

    public static SlotEntity toSlotEntity(SlotReqDTO slotReqDTO) {
        return SlotEntity.builder()
                .id(UUID.randomUUID().toString())
                .time(slotReqDTO.time())
                .doctorId(slotReqDTO.doctorId())
                .doctorName(slotReqDTO.doctorName())
                .cost(slotReqDTO.cost())
                .build();
    }

    public static SlotResDTO toSlotResDTO(SlotEntity slotEntity) {
        return SlotResDTO.builder()
                .id(slotEntity.getId())
                .time(slotEntity.getFormattedTime())
                .cost(slotEntity.getCost())
                .isReserved(slotEntity.isReserved())
                .build();
    }

}
