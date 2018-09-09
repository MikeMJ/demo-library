package com.mikola.demolibrary.dao;

import com.mikola.demolibrary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mikola on  Sep 08, 2018
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where upper(b.name) like concat('%',upper(:filter),'%') or upper(b.author) like concat('%',upper(:filter) ,'%') or upper(b.isbn) like concat('%',upper(:filter) ,'%')  ")
    Page<Book> getBooksMatchingFilter(@Param("filter")String filter, Pageable pageable);
    @Query("select b from Book b join fetch b.reservations where b.id = :id")
    Book getBookWithReservations(@Param("id")Long id);
}
