package com.example.passguard.repositories.DAO;

import com.example.passguard.repositories.entities.TokenEntity;

public interface TokenDaoI extends GenericDaoI<TokenEntity, Long> {
    public TokenEntity getTokenByTokenValue(String tokenValue);
}
