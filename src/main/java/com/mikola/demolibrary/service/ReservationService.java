package com.mikola.demolibrary.service;

/**
 * Created by Mikola on  Sep 07, 2018
 */
public interface ReservationService {
    void reserve(long bookId,long userId);
    void release(long bookId);
}