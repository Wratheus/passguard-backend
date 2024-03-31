package com.example.passguard.requests.user;

import com.example.passguard.models.Response;
import com.example.passguard.requests.user.get.GetUserRequest;
import com.example.passguard.util.ResponseConstants;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class UserService {

    public Response getResponse(GetUserRequest request) {
        return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK, new User(request.getId()));
    }
}
