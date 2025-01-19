package com.appointment_booking.doctor_availability.internal.controller;

import com.appointment_booking.doctor_availability.internal.dto.SlotReqDTO;
import com.appointment_booking.doctor_availability.internal.dto.SlotResDTO;
import com.appointment_booking.doctor_availability.internal.service.SlotService;
import com.appointment_booking.shared.dto.ResDTO;
import com.appointment_booking.shared.dto.ResDTOMessage;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/slot")
public class SlotController {

    SlotService slotService;

    @PostMapping
    public ResponseEntity< ResDTO<Object>> addSlot(@RequestBody SlotReqDTO slotReqDTO) throws Exception {
        slotService.addSlot(slotReqDTO);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS
        ,"Slot created successfully"), HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<ResDTO<List<SlotResDTO>>> getSlotsByDoctorID(@PathVariable String doctorId) throws Exception {
        List<SlotResDTO> res=slotService.getDoctorSlots(doctorId);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS
                ,res), HttpStatus.OK);
    }
}
