package com.mikola.demolibrary.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mikola on  Sep 07, 2018
 */
@Data
@Entity
@Table(name = "USERS")
public class User {
    @GeneratedValue
    @Id
    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    public User() {

    }

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("ID - %d, User name - %s,Name - %s %s", id, userName, firstName, lastName);
    }


}
