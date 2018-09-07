package com.mikola.demolibrary.service;

import com.mikola.demolibrary.model.Book;

import java.util.List;

/**
 * Created by Mikola on  Sep 07, 2018
 */
public interface ViewerService {
    List<Book> listBooks(String filter);

    Book showBookDetail(long bookId);

}
