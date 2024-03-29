package com.example.passguard.user.get;

import com.example.passguard.models.BaseService;
import com.example.passguard.models.Response;
import com.example.passguard.user.User;
import com.example.passguard.util.Constants;

import java.net.HttpURLConnection;

public class GetUserService extends BaseService {
    public GetUserService(GetUserRequest request) {
        super(request);
    }

    public Response getResponse() {
        GetUserRequest request;
        if (getRequest() instanceof GetUserRequest) {
            request = (GetUserRequest) getRequest();
        } else {
            return new Response(Constants.ERROR, HttpURLConnection.HTTP_CONFLICT, null);
        }
        return new Response(Constants.SUCCESS, HttpURLConnection.HTTP_OK, new User(request.getId()));
    }
}
