package com.example.passguard.requests.password.get;

import com.example.passguard.models.BaseRequest;

public class GetPasswordRequest extends BaseRequest {

    private final int id;

    public GetPasswordRequest(String token, int id) {
        super(token);
        this.id = id;
    }
}