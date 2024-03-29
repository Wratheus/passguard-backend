package com.example.passguard.password;

import com.example.passguard.util.BaseRequest;

import java.util.ArrayList;
import java.util.List;

public class GetPasswordRequest extends BaseRequest  {

    private int userId;

    public GetPasswordRequest(String token) {
        super(token);
    }

    public int getUserId() {
        return userId;
    }

}