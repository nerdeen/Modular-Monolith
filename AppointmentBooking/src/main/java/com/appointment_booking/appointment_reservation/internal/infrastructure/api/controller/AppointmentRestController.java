package com.appointment_booking.appointment_reservation.internal.infrastructure.api.controller;

import com.appointment_booking.appointment_reservation.internal.application.usecases.AppointmentBookingUseCase;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.AppointmentReqDTO;
import com.appointment_booking.shared.dto.ResDTO;
import com.appointment_booking.shared.dto.ResDTOMessage;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/appointments")
public class AppointmentRestController {

    AppointmentBookingUseCase appointmentBookingUseCase;

    public AppointmentRestController(AppointmentBookingUseCase appointmentBookingUseCase) {
        this.appointmentBookingUseCase = appointmentBookingUseCase;
    }

    @Operation(summary = "Book an Appointment", description = "Book a new appointment based on the provided appointment request details.")
    @PostMapping("/book")
    public ResponseEntity<ResDTO<Object>> bookAppointment(@RequestBody AppointmentReqDTO appointmentReqDTO) throws Exception {
        String appointmentId=appointmentBookingUseCase.bookAppointment(appointmentReqDTO);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS
                ,"Appointment Booked successfully with ID: "+ appointmentId), HttpStatus.OK);
    }

}