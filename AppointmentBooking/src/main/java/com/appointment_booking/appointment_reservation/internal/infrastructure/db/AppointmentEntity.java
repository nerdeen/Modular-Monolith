package com.appointment_booking.appointment_reservation.internal.infrastructure.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "appointments")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false, length = 36)
    private String id;

    @Column(name = "slot_id")
    private String slotId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "status")
    private String status;

    @Column(name = "reserved_at")
    private LocalDateTime reservedAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Transient
    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return time.format(formatter);
    }

    @PrePersist
    protected void onCreate() {
        this.reservedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
