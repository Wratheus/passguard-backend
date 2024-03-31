package com.example.passguard.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    private Long userId;
    private String token;

}

