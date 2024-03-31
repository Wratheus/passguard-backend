package com.example.passguard.requests.password;

import com.example.passguard.models.Response;
import com.example.passguard.requests.password.get.GetPasswordRequest;
import com.example.passguard.util.ResponseConstants;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class PasswordService {

    public Response getResponse(GetPasswordRequest request) {
        return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK, new Password("password", "login"));
    }
}
