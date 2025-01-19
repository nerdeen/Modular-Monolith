package com.appointment_booking.doctor_availability.internal.repository;

import com.appointment_booking.doctor_availability.internal.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<SlotEntity, String> {
    List<SlotEntity> findByDoctorIdAndTimeAfter(String doctorId, LocalDateTime timeAfter);
    boolean existsByDoctorId(String doctorId);
}
