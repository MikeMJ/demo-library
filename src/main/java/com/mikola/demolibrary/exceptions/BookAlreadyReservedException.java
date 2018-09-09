package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.ResponseCode;

/**
 * Created by Mikola on  Sep 10, 2018
 */
public class BookAlreadyReservedException extends GenericException {
    public BookAlreadyReservedException(String message, Exception cause, String... params) {
        super(message, cause, ResponseCode.BookReserved.getCode(), params);
    }

    public BookAlreadyReservedException(String message, String... params) {
        super(message, ResponseCode.BookReserved.getCode(), params);
    }

}
