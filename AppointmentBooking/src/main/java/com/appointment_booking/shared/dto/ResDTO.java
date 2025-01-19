package com.appointment_booking.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResDTO<T> implements Serializable {
    private Boolean success;

    private ResDTOMessage message;

    private T payload;
}
