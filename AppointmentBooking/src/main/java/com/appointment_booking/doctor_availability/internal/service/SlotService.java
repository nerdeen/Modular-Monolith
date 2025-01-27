package com.appointment_booking.doctor_availability.internal.service;

import com.appointment_booking.doctor_availability.internal.dto.Mapper;
import com.appointment_booking.doctor_availability.internal.dto.SlotReqDTO;
import com.appointment_booking.doctor_availability.internal.dto.SlotResDTO;
import com.appointment_booking.doctor_availability.shared.sharedDB.db.SlotEntity;
import com.appointment_booking.doctor_availability.shared.sharedDB.repository.SlotRepository;
import com.appointment_booking.shared.exception.BusinessException;
import com.appointment_booking.shared.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SlotService {

    private final SlotRepository slotRepository;

    public void addSlot(SlotReqDTO slotReqDTO) throws Exception {
        LocalDateTime currentTime = LocalDateTime.now();

        if (slotReqDTO.time().isBefore(currentTime.plusHours(1))) {
            throw new BusinessException("The slot time must be at least 1 hour ahead of the current time.");
        }

        slotRepository.save(Mapper.toSlotEntity(slotReqDTO));
    }

    public List<SlotResDTO> getDoctorSlots(String doctorId) {

        if (!slotRepository.existsByDoctorId(doctorId)) {
            throw new NotFoundException("No doctor found with ID: %s".formatted(doctorId));
        }

        List<SlotEntity> slots = slotRepository.findByDoctorIdAndTimeAfter(doctorId, LocalDateTime.now());
        if (null == slots || slots.isEmpty()) {
            throw new NotFoundException("No upcoming slots available for doctor ID: %s".formatted(doctorId));
        }

        return slots.stream().map(Mapper::toSlotResDTO).collect(Collectors.toList());
    }
}
