package com.appointment_booking.appointment_reservation.internal.infrastructure.api.controller;



import com.appointment_booking.appointment_reservation.internal.application.usecases.ViewAllAvailableSlotsUseCase;
import com.appointment_booking.appointment_reservation.internal.infrastructure.api.dto.SlotsResDTO;
import com.appointment_booking.shared.dto.ResDTO;
import com.appointment_booking.shared.dto.ResDTOMessage;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/appointment/slot")
public class SlotsRestController {

    ViewAllAvailableSlotsUseCase viewAllAvailableSlotsUseCase;

    public SlotsRestController(ViewAllAvailableSlotsUseCase viewAllAvailableSlotsUseCase) {
        this.viewAllAvailableSlotsUseCase = viewAllAvailableSlotsUseCase;
    }

    @Operation(summary = "View All doctors' Available Slots", description = "Retrieve for patients all the available slots for appointment booking.")
    @GetMapping
    public ResponseEntity<ResDTO<List<SlotsResDTO>>> viewSlots() throws Exception {
        List<SlotsResDTO> availableSlots=viewAllAvailableSlotsUseCase.viewSlots();
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS,availableSlots), HttpStatus.OK);
    }
}