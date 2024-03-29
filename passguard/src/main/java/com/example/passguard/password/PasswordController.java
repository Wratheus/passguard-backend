package com.example.passguard.password;
import com.example.passguard.models.Response;
import com.example.passguard.password.get.GetPasswordRequest;
import com.example.passguard.password.get.GetPasswordService;
import com.example.passguard.util.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @PostMapping("/get")
    public String getPassword(@RequestBody GetPasswordRequest request) {
        final GetPasswordService service = new GetPasswordService(request);
        final Response response = service.getResponse();
        return Resource.fromResponse(response);
    }
}
