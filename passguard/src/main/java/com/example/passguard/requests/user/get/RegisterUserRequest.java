package com.example.passguard.requests.user.get;

import com.example.passguard.models.BaseRequest;

public class RegisterUserRequest extends BaseRequest {
    private final String email;
    private final String username;
    private final String password;

    public RegisterUserRequest(String email, String username, String password) {
        super("");
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
