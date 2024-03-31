package com.example.passguard.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    private final long userId;
    private final String token;
    private final long date;


    public long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public TokenEntity(long id, long userId, String token, long date) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.date = date;
    }
}

