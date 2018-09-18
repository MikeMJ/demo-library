package com.mikola.demolibrary.service;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.exceptions.NoSuchBookException;
import com.mikola.demolibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Mikola on  Sep 09, 2018
 */
@Service
public class ViewerServiceImpl implements ViewerService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> listBooks(String filter, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookRepository.getBooksMatchingFilter(filter, pageable);
    }

    @Override
    public Book showBookDetails(long bookId) throws NoSuchBookException {
        Optional<Book> book = bookRepository.findById(bookId);
        if (!book.isPresent())
            throw new NoSuchBookException("No book found having the id that matches " + bookId);
        return book.get();
    }
}
