package com.example.passguard.requests.user;

import com.example.passguard.models.Response;
import com.example.passguard.requests.user.get.GetUserRequest;
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
        final Response response = service.getResponse(request);
        return Resource.fromResponse(response);
    }
}
