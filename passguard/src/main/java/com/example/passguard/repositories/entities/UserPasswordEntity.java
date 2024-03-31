package com.example.passguard.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "passwords")
public class UserPasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final long userId;
    private final String password;
    private final long date;

    public UserPasswordEntity(long userId, String password, long date) {
        this.userId = userId;
        this.password = password;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public long getDate() {
        return date;
    }
}

