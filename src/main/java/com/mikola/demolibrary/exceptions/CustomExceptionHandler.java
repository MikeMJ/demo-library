package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Mikola on  Sep 10, 2018
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BookAlreadyReservedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Response handleInternalCheckException(BookAlreadyReservedException ex) {
        return new Response(ex.getMessage(), ex.getErrorCode());
    }
}
