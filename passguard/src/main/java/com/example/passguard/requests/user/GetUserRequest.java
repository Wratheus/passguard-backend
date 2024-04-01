package com.example.passguard.requests.user;


import org.springframework.lang.NonNull;

public record GetUserRequest(@NonNull String token) {
}
