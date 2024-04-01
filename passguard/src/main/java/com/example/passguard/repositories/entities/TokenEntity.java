package com.example.passguard.repositories.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    @NonNull
    private long userId;
    @Column(name = "token")
    @NonNull
    private String token;
    @Column(name = "date")
    @NonNull
    private long date;


    public long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setDate(long date) {
        this.date = date;
    }
}

