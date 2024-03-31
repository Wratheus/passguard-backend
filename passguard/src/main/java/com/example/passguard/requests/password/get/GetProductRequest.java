package com.example.passguard.requests.password.get;

import com.example.passguard.models.BaseRequest;

public class GetProductRequest extends BaseRequest {

    private final int id;

    public GetProductRequest(String token, int id) {
        super(token);
        this.id = id;
    }
}