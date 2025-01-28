package com.appointment_booking.doctor_appointment_management.internal.adapter;

import com.appointment_booking.doctor_appointment_management.internal.ports.input.AppointmentService;
import com.appointment_booking.shared.dto.AppointmentResDTO;
import com.appointment_booking.shared.dto.ResDTO;
import com.appointment_booking.shared.dto.ResDTOMessage;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/manage/appointment")
public class DoctorAppointmentController {

    AppointmentService appointmentService;

    public DoctorAppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Operation(summary = "Get Upcoming Appointments by Doctor ID", description = "Retrieve a list of upcoming scheduled appointments for a specific doctor.")
    @GetMapping("/{doctorId}")
    public ResponseEntity<ResDTO<List<AppointmentResDTO>>> getAppointments(@PathVariable String doctorId) throws Exception{
        List<AppointmentResDTO> appointmentResDTOS= appointmentService.getUpcomingScheduledAppointmentsByDoctorId(doctorId);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE, ResDTOMessage.SUCCESS,appointmentResDTOS), HttpStatus.OK);
    }

    @Operation(summary = "Complete an Appointment", description = "Mark an appointment as completed based on its ID , if this Appointment already cancelled return an error message.")
    @PutMapping("/complete/{appointmentId}")
    public ResponseEntity<ResDTO<Object>> completeAppointment(@PathVariable String appointmentId) throws Exception {
        appointmentService.markAppointmentAsCompleted(appointmentId);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE
                , ResDTOMessage.SUCCESS
                ,"Appointment Completed successfully...")
                , HttpStatus.OK);
    }

    @Operation(summary = "Cancel an Appointment", description = "Mark an appointment as cancelled based on its ID , if this Appointment already Completed return an error message, if the slot time still in the future release it to be available slot again.")
    @PutMapping("/cancel/{appointmentId}")
    public ResponseEntity<ResDTO<Object>> cancelAppointment(@PathVariable String appointmentId) throws Exception{
        appointmentService.markAppointmentAsCancelled(appointmentId);
        return new ResponseEntity<>(new ResDTO<>(Boolean.TRUE
                , ResDTOMessage.SUCCESS
                ,"Appointment Cancelled successfully...")
                , HttpStatus.OK);
    }
}
