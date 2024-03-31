package com.example.passguard.requests.user;

import com.example.passguard.models.Response;
import com.example.passguard.requests.user.get.GetUserRequest;
import com.example.passguard.requests.user.get.RegisterUserRequest;
import com.example.passguard.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/get")
    public String getUser(@RequestBody GetUserRequest request) {
        final Response response = service.getUser(request);
        return Resource.fromResponse(response);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUserRequest request) {
        final Response response = service.registerUser(request);
        return Resource.fromResponse(response);
    }
}
