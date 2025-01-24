package com.appointment_booking.appointment_reservation.internal.domain.repo;

import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;
import com.appointment_booking.doctor_availability.internal.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotsRepo  extends JpaRepository<SlotEntity, String> {
    @Query("SELECT s FROM SlotEntity s WHERE s.time > :currentTime AND s.isReserved = false")
    List<SlotEntity> findAvailableSlotsAfter(@Param("currentTime") LocalDateTime currentTime);

    @Modifying
    @Transactional
    @Query("UPDATE SlotEntity s SET s.isReserved = true WHERE s.id = :slotId")
    int markSlotAsReserved(String slotId);
}

