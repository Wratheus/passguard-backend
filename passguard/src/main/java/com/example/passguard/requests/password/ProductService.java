package com.example.passguard.requests.password;

import com.example.passguard.models.Product;
import com.example.passguard.models.Response;
import com.example.passguard.requests.password.get.GetProductRequest;
import com.example.passguard.util.ResponseConstants;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;

@Service
public class ProductService {

    public Response getResponse(GetProductRequest request) {
        return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK, new Product("password", "login"));
    }
}
