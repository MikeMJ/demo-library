package com.mikola.demolibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    @Column(unique = true)
    private String isbn;
    private String name;
    private String author;
    @JsonIgnore
    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    public Book() {

    }

    public Book(String isbn, String name, String author) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Isbn - %s, Name - %s, Author - %s", isbn, name, author);
    }

}
