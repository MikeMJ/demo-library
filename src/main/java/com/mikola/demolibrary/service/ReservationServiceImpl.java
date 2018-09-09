package com.mikola.demolibrary.service;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.dao.ReservationRepository;
import com.mikola.demolibrary.dao.UserRepository;
import com.mikola.demolibrary.exceptions.*;
import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.model.Reservation;
import com.mikola.demolibrary.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Created by Mikola on  Sep 09, 2018
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

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
    public long reserve(long bookId, long userId) throws BookAlreadyReservedException, NoSuchBookException, NoSuchUserException, InternalException {
        Optional<Book> book = bookRepository.findById(bookId);
        if (!book.isPresent())
            throw new NoSuchBookException("No book found having the id that matches " + bookId);
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent())
            throw new NoSuchUserException("No user found having the id that matches " + userId);
        Reservation reservation = reservationRepository.findByBookEqualsAndReleaseDateIsNull(book.get());
        if (reservation != null)
            throw new BookAlreadyReservedException("The book you're trying to reserve has already been reserved");
        reservation = new Reservation(book.get(), user.get());
        reservation.setReservationDate(new Date());
        try {
            reservationRepository.save(reservation);
        } catch (Exception ex) {
            throw new InternalException("An error occurred while trying to reserve the book", ex);
        }
        return reservation.getId();
    }

    @Override
    public void release(long bookId) throws NoReservationException, InternalException {
        logger.info("Checking if there is a reservation on the book with id {}", bookId);
        Reservation reservation = reservationRepository.getReservationForBook(bookId);
        if (reservation == null)
            throw new NoReservationException("No reservation found to release");
        logger.info("A reservation found. Reservation id {}", reservation.getId());
        reservation.setReleaseDate(new Date());
        logger.info("Releasing the reservation on book with id {}", bookId);
        try {
            reservationRepository.save(reservation);
        } catch (Exception ex) {
            throw new InternalException("An error occurred while trying to release the reservation", ex, "bookId=" + bookId);
        }
    }
}
