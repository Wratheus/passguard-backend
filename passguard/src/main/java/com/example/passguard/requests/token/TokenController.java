package com.example.passguard.requests.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    private final TokenService service;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.service = tokenService;
    }

    // Обработка HTTP запросов
}

