package com.example.passguard.user.get;

import com.example.passguard.user.User;
import com.example.passguard.util.BaseResponse;

public class GetUserResponse extends BaseResponse {
    private final User user;

    public GetUserResponse(String status, Integer code, User user) {
        super(status, code);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
