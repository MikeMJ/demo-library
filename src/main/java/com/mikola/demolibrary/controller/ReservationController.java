package com.mikola.demolibrary.controller;

import com.mikola.demolibrary.exceptions.GenericException;
import com.mikola.demolibrary.response.Response;
import com.mikola.demolibrary.response.ResponseCode;
import com.mikola.demolibrary.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mikola on  Sep 10, 2018
 */
@Validated
@RestController
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    private ReservationService reservationService;


    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response reserveBook(@RequestParam(value = "bookid", required = true) Long bookId,
                                @RequestParam(value = "userid", required = true) Long userId) throws GenericException {
        logger.info("Received request to reserve the book with id {}", bookId);
        Long reservationId = reservationService.reserve(bookId, userId);
        logger.info("Book reserved. Reservation id:{}",reservationId);
        Map<String,Object> map = new HashMap<>();
        map.put("reservation-id",reservationId);
        return new Response(ResponseCode.Ok.getCode(),"OK", map);
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response reserveBook(@RequestParam(value = "bookid", required = true) Long bookId) throws GenericException {
        logger.info("Received request to release the reservation on the book with id {}", bookId);
        reservationService.release(bookId);
        logger.info("Reservation released on book with id id:{}",bookId);
        return new Response(ResponseCode.Ok.getCode(),"OK");
    }
}
