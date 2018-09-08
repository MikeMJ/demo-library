package com.mikola.demolibrary.dao;

import com.mikola.demolibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mikola on  Sep 08, 2018
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
