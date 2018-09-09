package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.ResponseCode;

/**
 * Created by Mikola on  Sep 10, 2018
 */
public class NoSuchBookException extends GenericException {
    public NoSuchBookException(String message, Exception cause, String... params) {
        super(message, cause, ResponseCode.NoSuchBook.getCode(), params);
    }

    public NoSuchBookException(String message,  String... params) {
        super(message, ResponseCode.NoSuchBook.getCode(), params);
    }
}
