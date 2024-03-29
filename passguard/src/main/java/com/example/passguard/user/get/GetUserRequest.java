package com.example.passguard.user.get;

import com.example.passguard.util.BaseRequest;

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
