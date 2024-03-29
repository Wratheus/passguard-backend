package com.example.passguard.models;

public abstract class BaseRequest {
    final private String token;

    public BaseRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
