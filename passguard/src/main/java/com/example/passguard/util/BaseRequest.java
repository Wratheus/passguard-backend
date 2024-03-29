package com.example.passguard.util;

public abstract class BaseRequest {
    final private String token;

    public BaseRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
