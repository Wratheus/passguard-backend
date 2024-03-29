package com.example.passguard.user;

import com.example.passguard.util.BaseService;

import java.net.HttpURLConnection;

public class GetUserService extends BaseService {
    public GetUserService(GetUserRequest request) {
        super(request);
    }

    public GetUserResponse getResponse() {
        GetUserRequest request;
        if (getRequest() instanceof GetUserRequest) {
            request = (GetUserRequest) getRequest();
        } else {
            return new GetUserResponse("ERROR", HttpURLConnection.HTTP_CONFLICT, null);
        }
        return new GetUserResponse("SUCCESS", HttpURLConnection.HTTP_OK, new User(request.getId()));
    }
}
