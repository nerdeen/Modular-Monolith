package com.appointment_booking.appointment_reservation.internal.api;



import com.appointment_booking.appointment_reservation.internal.domain.dto.SlotsResDTO;
import com.appointment_booking.appointment_reservation.internal.domain.service.SlotsService;
import com.appointment_booking.shared.dto.ResDTO;
import com.appointment_booking.shared.dto.ResDTOMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/slots")
public class SlotsRestController {

    SlotsService slotsService;

    @GetMapping("/view")
    public ResponseEntity<ResDTO<List<SlotsResDTO>>> viewSlots() throws Exception {
        List<SlotsResDTO> availableSlots=slotsService.viewSlots();
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS,availableSlots), HttpStatus.OK);
    }
}