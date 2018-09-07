package com.mikola.demolibrary.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Mikola on  Sep 07, 2018
 */
@Entity
@Data
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String isbn;
    private String name;
    private String author;

    @Override
    public String toString() {
        return String.format("Isbn - %s, Name - %s, Author - %s", isbn, name, author);
    }

}
