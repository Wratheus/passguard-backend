package com.example.passguard.user;

import com.example.passguard.models.Response;
import com.example.passguard.user.get.GetUserRequest;
import com.example.passguard.user.get.GetUserService;
import com.example.passguard.util.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/get")
    public String getUser(@RequestBody GetUserRequest request) {
        final GetUserService service = new GetUserService(request);
        final Response response = service.getResponse();
        return Resource.fromResponse(response);
    }
}
