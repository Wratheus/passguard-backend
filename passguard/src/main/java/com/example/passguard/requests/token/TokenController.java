package com.example.passguard.requests.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TokenController {

    private final TokenService service;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.service = tokenService;
    }

    public String getTokenById(long userId) {
        Optional<String> token = service.getToken(userId);
        return token.orElse("token not found");
    }
}

