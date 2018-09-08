package com.mikola.demolibrary.service;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mikola on  Sep 09, 2018
 */
@Service
public class ViewerServiceImpl implements ViewerService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> listBooks(String filter) {
        return bookRepository.findAll();
    }

    @Override
    public Book showBookDetails(long bookId) {
        return bookRepository.getOne(bookId);
    }
}
