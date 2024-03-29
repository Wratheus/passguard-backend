package com.example.passguard.password;

import com.example.passguard.util.BaseRequest;

public class GetPasswordRequest extends BaseRequest  {

    private final int id;

    public GetPasswordRequest(String token, int id) {
        super(token);
        this.id = id;
    }

    public int getId() {
        return id;
    }

}