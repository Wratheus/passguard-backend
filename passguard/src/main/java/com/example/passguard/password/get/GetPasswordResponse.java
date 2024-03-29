package com.example.passguard.password.get;

import com.example.passguard.password.Password;
import com.example.passguard.util.BaseResponse;

public class GetPasswordResponse extends BaseResponse {
    private final Password password;

    public GetPasswordResponse(String status, Integer code, Password password) {
        super(status, code);
        this.password = password;
    }

    public Password getPassword() {
        return password;
    }
}
