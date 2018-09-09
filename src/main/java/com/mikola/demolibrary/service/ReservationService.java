package com.mikola.demolibrary.service;

import com.mikola.demolibrary.exceptions.*;

/**
 * Created by Mikola on  Sep 07, 2018
 */
public interface ReservationService {
    long reserve(long bookId, long userId) throws BookAlreadyReservedException, NoSuchBookException, NoSuchUserException, InternalException;

    void release(long bookId) throws NoReservationException,InternalException;
}
