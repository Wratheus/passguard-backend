package com.example.passguard.requests.token;

import com.example.passguard.repositories.DAO.TokenDAO;
import com.example.passguard.repositories.entities.TokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenDAO tokenDAO;

    @Autowired
    public TokenService(TokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

    public String getToken(Long id) {
        TokenEntity entity = tokenDAO.findById(TokenEntity.class, id);

        return entity.toString();
    }
}
