package com.example.passguard.password.get;

import com.example.passguard.password.Password;
import com.example.passguard.user.get.GetUserRequest;
import com.example.passguard.util.BaseService;
import com.example.passguard.util.Constants;

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
            return new GetPasswordResponse(Constants.ERROR, HttpURLConnection.HTTP_CONFLICT, null);
        }
        return new GetPasswordResponse(Constants.SUCCESS, HttpURLConnection.HTTP_OK, new Password("password", "login"));
    }
}
