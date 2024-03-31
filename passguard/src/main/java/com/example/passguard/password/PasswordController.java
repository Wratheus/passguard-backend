package com.example.passguard.password;
import com.example.passguard.models.Response;
import com.example.passguard.password.get.GetPasswordRequest;
import com.example.passguard.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {
    final private PasswordService service;

    @Autowired
    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @PostMapping("/get")
    public String getPassword(@RequestBody GetPasswordRequest request) {
        final Response response = service.getResponse(request);
        return Resource.fromResponse(response);
    }
}
