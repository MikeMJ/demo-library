package com.mikola.demolibrary.service;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.dao.ReservationRepository;
import com.mikola.demolibrary.dao.UserRepository;
import com.mikola.demolibrary.exceptions.BookAlreadyReservedException;
import com.mikola.demolibrary.exceptions.NoSuchBookException;
import com.mikola.demolibrary.exceptions.NoSuchUserException;
import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.model.Reservation;
import com.mikola.demolibrary.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Mikola on  Sep 10, 2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceImplTest {

    private static final Long DUMMY_BOOK_ID = 113L;
    private static final Long DUMMY_USER_ID = 1l;

    private ReservationServiceImpl reservationService;

    @MockBean
    private ReservationRepository reservationRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private BookRepository bookRepository;

    @Before
    public void setUp(){
        reservationService = new ReservationServiceImpl(reservationRepository,bookRepository,userRepository);
    }

    @Test(expected = NoSuchBookException.class)
    public void throwsExceptionWhenTryingToReserveNonexistentBook() throws Exception{
        when(bookRepository.findById(anyLong())).thenReturn(Optional.empty());
        reservationService.reserve(DUMMY_BOOK_ID,DUMMY_USER_ID);
    }

    @Test(expected = NoSuchUserException.class)
    public void throwsExceptionWhenTryingToReserveForNonExistentUser() throws Exception{
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(new Book()));
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        reservationService.reserve(DUMMY_BOOK_ID,DUMMY_USER_ID);
    }

    @Test(expected = BookAlreadyReservedException.class)
    public void throwsExceptionWhenBookReservedAlready() throws Exception{
        Book book = new Book();
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(book));
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(new User()));
        when(reservationRepository.findByBookEqualsAndReleaseDateIsNull(book)).thenReturn(new Reservation());
        reservationService.reserve(DUMMY_BOOK_ID,DUMMY_USER_ID);
    }

    //TODO Add a normal case for reservation
    //TODO Add cases for release.


}