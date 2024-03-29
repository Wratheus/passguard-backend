package com.example.passguard.password.get;

import com.example.passguard.models.BaseRequest;

public class GetPasswordRequest extends BaseRequest {

    private final int id;

    public GetPasswordRequest(String token, int id) {
        super(token);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}