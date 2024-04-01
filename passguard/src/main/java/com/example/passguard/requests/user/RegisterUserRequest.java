package com.example.passguard.requests.user;

import org.springframework.lang.NonNull;

public record RegisterUserRequest(@NonNull String email, @NonNull String username, @NonNull String password) {
}
