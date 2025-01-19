package com.appointment_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackageClasses = AppointmentBookingApplication.class)
public class AppointmentBookingApplication {

    public static void main(String[] args) {
        ApplicationModules.of(AppointmentBookingApplication.class).verify();
        SpringApplication.run(AppointmentBookingApplication.class, args);
    }

}
