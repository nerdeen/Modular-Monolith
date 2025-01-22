package com.appointment_booking.appointment_reservation.internal.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    @Column(name = "reserved_at")
    private LocalDate reservedAt;


    @Transient
    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return reservedAt.format(formatter);
    }

    @PrePersist
    protected void onCreate() {
        this.reservedAt = LocalDate.now();
    }


}
