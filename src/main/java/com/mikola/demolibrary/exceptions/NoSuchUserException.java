package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.ResponseCode;

/**
 * Created by Mikola on  Sep 10, 2018
 */
public class NoSuchUserException extends GenericException {
    public NoSuchUserException(String message, Exception cause, String... params) {
        super(message, cause, ResponseCode.NoSuchUser.getCode(), params);
    }

    public NoSuchUserException(String message, String... params) {
        super(message, ResponseCode.NoSuchUser.getCode(), params);
    }
}
