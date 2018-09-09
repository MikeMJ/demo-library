package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.ResponseCode;

/**
 * Created by Mikola on  Sep 10, 2018
 */
public class InternalException extends GenericException {
    public InternalException(String message, Exception cause, String... params) {
        super(message, cause, ResponseCode.Internal.getCode(), params);
    }

    public InternalException(String message,  String... params) {
        super(message, ResponseCode.Internal.getCode(), params);
    }
}
