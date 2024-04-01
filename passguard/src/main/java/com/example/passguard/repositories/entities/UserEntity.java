package com.example.passguard.repositories.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "email")
    @NonNull
    private String email;
    @Column(name = "username")
    @NonNull
    private String username;
    @Column(name = "date")
    @NonNull
    private long date;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(long date) {
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", date=" + date +
                '}';
    }
}
