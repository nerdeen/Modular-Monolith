package com.appointment_booking.appointment_reservation.internal.api;



import com.appointment_booking.appointment_reservation.internal.domain.dto.AppointmentReqDTO;
import com.appointment_booking.appointment_reservation.internal.domain.service.AppointmentService;
import com.appointment_booking.shared.dto.ResDTO;
import com.appointment_booking.shared.dto.ResDTOMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentRestController {

    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<ResDTO<Object>> bookAppointment(@RequestBody AppointmentReqDTO appointmentReqDTO) throws Exception {
        appointmentService.bookAppointment(appointmentReqDTO);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS
                ,"Appointment Booked  successfully"), HttpStatus.OK);
    }

}