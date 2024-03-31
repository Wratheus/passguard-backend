package com.example.passguard.requests.user.get;

import com.example.passguard.models.BaseRequest;

public class GetUserRequest extends BaseRequest {
    private final int id;

    public int getId() {
        return id;
    }


    public GetUserRequest(int id, String token) {
        super(token);
        this.id = id;
    }
}
