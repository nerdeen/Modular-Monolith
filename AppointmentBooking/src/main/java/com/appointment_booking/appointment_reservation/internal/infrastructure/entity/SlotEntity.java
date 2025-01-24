//package com.appointment_booking.appointment_reservation.internal.infrastructure.entity;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//
//@Entity
//@Table(name = "slots")
//@Setter
//@Getter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class SlotEntity {
//    @Id
//    @Column(name = "id", updatable = false, nullable = false, length = 36)
//    private String id;
//
//    @Column(name = "time")
//    private LocalDateTime time;
//
//    @Column(name = "doctor_id")
//    private String doctorId;
//
//    @Column(name = "doctor_name")
//    private String doctorName;
//
//    @Column(name = "is_reserved")
//    private boolean isReserved;
//
//    @Column(name = "cost")
//    private double cost;
//
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;
//
//    @Transient
//    public String getFormattedTime() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
//        return time.format(formatter);
//    }
//
//    @PrePersist
//    protected void onCreate() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = this.createdAt;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
//
//}
