package com.example.passguard.requests.user.get;

import com.example.passguard.models.BaseRequest;

public class GetUserRequest extends BaseRequest {
    private final long id;

    public long getId() {
        return id;
    }


    public GetUserRequest(long id, String token) {
        super(token);
        this.id = id;
    }
}
