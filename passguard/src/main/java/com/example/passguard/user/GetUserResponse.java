package com.example.passguard.user;

import com.example.passguard.util.BaseResponse;

public class GetUserResponse extends BaseResponse {
    private final User user;

    public GetUserResponse(String status, Integer code, User user) {
        super(status, code);
        this.user = user;
    }

}
