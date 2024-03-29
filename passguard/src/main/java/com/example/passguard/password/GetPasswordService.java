package com.example.passguard.password;

import com.example.passguard.user.GetUserRequest;
import com.example.passguard.util.BaseService;

import java.net.HttpURLConnection;

public class GetPasswordService extends BaseService {
    public GetPasswordService(GetPasswordRequest request) {
        super(request);
    }

    public GetPasswordResponse getResponse() {
        GetUserRequest request;
        if (getRequest() instanceof GetUserRequest) {
            request = (GetUserRequest) getRequest();
        } else {
            return new GetPasswordResponse("ERROR", HttpURLConnection.HTTP_CONFLICT, null);
        }
        return new GetPasswordResponse("SUCCESS", HttpURLConnection.HTTP_OK, new Password("password", "login"));
    }
}
