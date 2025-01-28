package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.application.gateways.SlotGateway;
import com.appointment_booking.appointment_reservation.internal.infrastructure.Mapper;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.SlotsResDTO;
import com.appointment_booking.doctor_availability.shared.sharedDB.db.SlotEntity;
import com.appointment_booking.doctor_availability.shared.sharedDB.repository.SlotRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SlotsRepo implements SlotGateway {

    SlotRepository slotRepository;

    public SlotsRepo(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public List<SlotsResDTO> findAllByReservedIsAndTimeAfter() {
        return slotRepository
                .findByReservedIsAndTimeAfter(false,LocalDateTime.now())
                .stream()
                .map(Mapper::toSlotsResDTO).collect(Collectors.toList());
    }

    public Optional<SlotEntity> findBySlotId(String slotId) {
        return slotRepository.findById(slotId);
    }

    @Override
    public void updateSlot(SlotEntity slotEntity) {
        slotRepository.save(slotEntity);
    }

    @Override
    public boolean doctorIdValidUseCase(String doctorId) {
        return slotRepository.existsByDoctorId(doctorId);
    }
}

