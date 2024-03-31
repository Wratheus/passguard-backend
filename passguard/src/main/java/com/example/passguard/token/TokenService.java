package com.example.passguard.token;

import com.example.passguard.repositories.DAO.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenDAO tokenDAO;

    @Autowired
    public TokenService(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

}
