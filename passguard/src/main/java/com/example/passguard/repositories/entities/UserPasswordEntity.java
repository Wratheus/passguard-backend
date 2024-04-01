package com.example.passguard.repositories.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullApi;

@Entity
@Table(name = "passwords")
public class UserPasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    @NonNull
    private long userId;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "date")
    @NonNull
    private long date;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(long date) {
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

