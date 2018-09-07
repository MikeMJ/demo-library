package com.mikola.demolibrary.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String name;

    @Override
    public String toString() {
        return String.format("ID - %d, Name - %s", id, name);
    }
}
