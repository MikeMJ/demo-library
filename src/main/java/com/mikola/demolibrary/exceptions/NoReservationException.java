package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.ResponseCode;

/**
 * Created by Mikola on  Sep 10, 2018
 */
public class NoReservationException extends GenericException {
    public NoReservationException(String message, Exception cause, String... params) {
        super(message, cause, ResponseCode.NoReservation.getCode(), params);
    }

    public NoReservationException(String message, String... params) {
        super(message, ResponseCode.NoReservation.getCode(), params);
    }
}
