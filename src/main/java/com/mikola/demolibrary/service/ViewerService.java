package com.mikola.demolibrary.service;

import com.mikola.demolibrary.exceptions.NoSuchBookException;
import com.mikola.demolibrary.model.Book;
import org.springframework.data.domain.Page;

/**
 * Created by Mikola on  Sep 07, 2018
 */
public interface ViewerService {
    Page<Book> listBooks(String filter, int pageNumber, int pageSize);

    Book showBookDetails(long bookId)throws NoSuchBookException;

}
