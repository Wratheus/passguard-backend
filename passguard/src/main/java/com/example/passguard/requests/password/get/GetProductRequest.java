package com.example.passguard.requests.password.get;

import org.springframework.lang.NonNull;

public class GetProductRequest {
    @NonNull
    private final Long id;
    @NonNull
    private final String token;

    public GetProductRequest(@NonNull String token, @NonNull Long id) {
        this.id = id;
        this.token = token;
    }
}