package com.example.passguard.password;
import com.example.passguard.util.BaseResponse;
import com.example.passguard.util.ResponseMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @GetMapping("/get")
    public String getPassword(@RequestBody GetPasswordRequest request) {
        final GetPasswordService service = new GetPasswordService(request);
        final BaseResponse response = service.getResponse();
        return ResponseMapper.map(response);
    }
}
