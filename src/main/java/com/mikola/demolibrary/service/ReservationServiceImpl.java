package com.mikola.demolibrary.service;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.dao.ReservationRepository;
import com.mikola.demolibrary.dao.UserRepository;
import com.mikola.demolibrary.exceptions.*;
import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.model.Reservation;
import com.mikola.demolibrary.model.User;
import com.mikola.demolibrary.response.Response;
import com.mikola.demolibrary.response.ResponseCode;
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
    public long reserve(long bookId, long userId) throws BookAlreadyReservedException, NoSuchBookException, NoSuchUserException,InternalException {
        Book book = bookRepository.getOne(bookId);
        if (book == null)
            throw new NoSuchBookException("No book found having the id that matches " + bookId);
        User user = userRepository.getOne(userId);
        if (user == null)
            throw new NoSuchUserException("No user found having the id that matches " + userId);
        Reservation reservation = reservationRepository.findByBookEqualsAndReleaseDateIsNull(book);
        if (reservation != null)
            throw new BookAlreadyReservedException("The book you're trying to reserve has already been reserved");
        reservation = new Reservation(book, user);
        try {
            reservationRepository.save(reservation);
        }catch (Exception ex){
            throw new InternalException("An error occurred while trying to reserve the book",ex);
        }
        return reservation.getId();
    }

    @Override
    public void release(long bookId) {
        //TODO Need to extend the JPARepository functionality to be able to say "Get me the reservation for this book where release data is null"
    }
}
