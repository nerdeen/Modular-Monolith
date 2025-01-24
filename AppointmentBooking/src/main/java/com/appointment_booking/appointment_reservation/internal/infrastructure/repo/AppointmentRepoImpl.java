package com.appointment_booking.appointment_reservation.internal.infrastructure.repo;

import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.domain.repo.AppointmentRepo;
//import com.appointment_booking.appointment_reservation.internal.infrastructure.entity.SlotEntity;
import com.appointment_booking.appointment_reservation.internal.infrastructure.entity.AppointmentEntity;
import com.appointment_booking.doctor_availability.internal.entity.SlotEntity;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalTime;
//
//@Repository
//public class AppointmentRepoImpl implements AppointmentRepo {
//
//    @Override
//    public void bookAppointment(AppointmentReqDTO appointmentReqDTO) {
////        SlotEntity slot=new SlotEntity();
//        SlotEntity slotEntity = new SlotEntity();
//        AppointmentEntity appointmentEntity = new AppointmentEntity();
//        appointmentEntity.setId(appointmentReqDTO.id());
//        appointmentEntity.setSlotId(appointmentReqDTO.slotId());
//        appointmentEntity.setPatientId(appointmentReqDTO.patientId());
//        appointmentEntity.setPatientName(appointmentReqDTO.patientName());
//        LocalTime currentTime = LocalTime.now();
//        appointmentEntity.setReservedAt(currentTime);
//    }
//}
