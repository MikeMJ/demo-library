package com.mikola.demolibrary.exceptions;

import com.mikola.demolibrary.response.Response;
import com.mikola.demolibrary.response.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by Mikola on  Sep 10, 2018
 */
@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BookAlreadyReservedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Response hadnleReservedBookException(BookAlreadyReservedException ex) {
        return new Response(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(NoSuchUserException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Response hadnleInvalidUserException(NoSuchUserException ex) {
        return new Response(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(NoSuchBookException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Response hadnleInvalidBookException(NoSuchBookException ex) {
        return new Response(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(NoReservationException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Response hadnleInvalidReservationException(NoReservationException ex) {
        return new Response(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(InternalException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    Response hadnleInternalException(InternalException ex) {
        return new Response(ex.getMessage(), ex.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    Response handleInvalidargumentValue(MethodArgumentTypeMismatchException ex) {
        return new Response("Invalid value supplied for '" + ex.getParameter().getParameterName() + "' parameter", ResponseCode.BadInputForParameter.getCode());
    }
}
