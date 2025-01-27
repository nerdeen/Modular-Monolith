package com.appointment_booking.appointment_confirmation.shared;

public interface NotificationApi {
    void notifyDoctor(String doctorId,String patientName);
    void notifyPatient(String doctorId,String patientName);
}
