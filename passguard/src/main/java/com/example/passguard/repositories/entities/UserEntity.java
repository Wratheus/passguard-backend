package com.example.passguard.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String email;
    private final String username;
    private final long date;

    public UserEntity(Long id, String email, String username, long date) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public long getDate() {
        return date;
    }
}
