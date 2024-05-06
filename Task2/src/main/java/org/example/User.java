package org.example;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
@Entity
class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "User: ID=" + id + ", Username='" + username + "'";
    }
}