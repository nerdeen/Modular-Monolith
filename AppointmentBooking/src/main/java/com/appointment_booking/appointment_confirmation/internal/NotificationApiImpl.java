package com.appointment_booking.appointment_confirmation.internal;

import com.appointment_booking.appointment_confirmation.shared.NotificationApi;

public class NotificationApiImpl implements NotificationApi {
    @Override
    public void notifyDoctor(String doctorName,String patientName) {
        System.out.println("New appointment has been reserved with doctor : " + doctorName + " from patient: " + patientName);

    }
    @Override
    public void notifyPatient(String doctorName,String patientName) {
        System.out.println("Dear Mr/Ms : "+ patientName+ "You have successfully reserved an appointment with Dr : " + doctorName);

    }

}
