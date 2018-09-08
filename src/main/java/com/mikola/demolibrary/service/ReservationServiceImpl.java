package com.mikola.demolibrary.service;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.dao.ReservationRepository;
import com.mikola.demolibrary.dao.UserRepository;
import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.model.Reservation;
import com.mikola.demolibrary.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mikola on  Sep 09, 2018
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public long reserve(long bookId, long userId) {
        Book book = bookRepository.getOne(bookId);
        User user = userRepository.getOne(userId);
        Reservation reservation = new Reservation(book,user);
        reservationRepository.save(reservation);
        return reservation.getId();
    }

    @Override
    public void release(long bookId) {
        //TODO Need to extend the JPARepository functionality to be able to say "Get me the reservation for this book where release data is null"
    }
}
