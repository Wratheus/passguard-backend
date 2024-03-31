package com.example.passguard.repositories.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    private final long userId;
    private final String password;
    private final String login;
    private final long date;

    public ProductEntity(long id, long userId, String password, String login, long date) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.login = login;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public long getDate() {
        return date;
    }
}
