package com.example.passguard.repositories.entities;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "user_id")
    @NonNull
    private long userId;
    @Column(name = "password")
    @NonNull
    private String password;
    @Column(name = "login")
    @NonNull
    private String login;
    @Column(name = "date")
    @NonNull
    private long date;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDate(long date) {
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
