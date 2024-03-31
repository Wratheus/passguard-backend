package com.example.passguard.requests.token;

import com.example.passguard.repositories.DAO.TokenEntityDAO;
import com.example.passguard.repositories.entities.TokenEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenService {

    private final TokenEntityDAO tokenDAO;

    @Autowired
    public TokenService(TokenEntityDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

    public Optional<String> getToken(Long id) {
        Optional<TokenEntity> entity = tokenDAO.findById(id);
        return entity.map(TokenEntity::getToken);
    }
}
