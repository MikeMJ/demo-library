package com.mikola.demolibrary.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mikola on  Sep 07, 2018
 */
@Entity
@Data
@Table(name = "RESERVATIONS")
public class Reservation {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Date reservationDate;
    private Date releaseDate;

    public Reservation(){
    }

    public Reservation(Book book, User user){
        this.book=book;
        this.user=user;
    }
}
