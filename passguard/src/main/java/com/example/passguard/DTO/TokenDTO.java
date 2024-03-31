package com.example.passguard.DTO;

public class TokenDTO {
    private Long userId;
    private String token;


    public Long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
