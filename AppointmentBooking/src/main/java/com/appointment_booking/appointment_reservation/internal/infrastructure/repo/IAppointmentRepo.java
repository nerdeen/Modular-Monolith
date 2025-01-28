package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.infrastructure.db.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAppointmentRepo extends JpaRepository<AppointmentEntity, String> {
    @Query(
            value = """
            SELECT a.*
            FROM appointments a
            JOIN slots s ON a.slot_id = s.id
            WHERE s.doctor_id = :doctorId
              AND a.status NOT IN ('COMPLETED', 'CANCELED')
              AND s.time > NOW()
            """,
            nativeQuery = true
    )
    List<AppointmentEntity> getUpcomingScheduledAppointmentsByDoctorId(@Param("doctorId") String doctorId);

    Optional<AppointmentEntity> findBySlotId(String slotId);

    @Transactional
    @Modifying
    @Query(
            value = """
            UPDATE slots
            SET is_reserved = false
            WHERE id = :slotId
            """,
            nativeQuery = true
    )
    void releaseSlotBySlotId(@Param("slotId") String slotId);
}
