package com.mikola.demolibrary.dao;

import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Mikola on  Sep 08, 2018
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByBookEqualsAndReleaseDateIsNull(Book book);

    @Query("select r from Reservation r join fetch r.book where r.book.id = :bookId")
    Reservation getReservationForBook(@Param("bookId") long bookId);
}
