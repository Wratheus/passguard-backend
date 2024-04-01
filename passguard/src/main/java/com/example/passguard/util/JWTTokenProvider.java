package com.example.passguard.util;

import com.example.passguard.repositories.DAO.TokenEntityDAO;
import com.example.passguard.repositories.entities.TokenEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;

import static com.example.passguard.PassguardApplication.LOGGER;

@Component
public class JWTTokenProvider {
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    private SecretKey secretKey;
    private final TokenEntityDAO tokenEntityDAO;

    @Autowired
    public JWTTokenProvider(@Value("${app.jwtSecret}") String jwtSecret, TokenEntityDAO tokenEntityDAO) {
        this.jwtSecret = jwtSecret;
        this.tokenEntityDAO = tokenEntityDAO;
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        // Извлечение токена из базы данных по переданному токену
        Optional<TokenEntity> tokenEntityOptional = tokenEntityDAO.findByToken(authToken);
        if (tokenEntityOptional.isEmpty()) {
            // Токен не найден в базе данных, считаем его недействительным
            return false;
        }

        // Получение токена из Optional
        TokenEntity tokenEntity = tokenEntityOptional.get();
        String storedToken = tokenEntity.getToken();

        // Проверка, совпадает ли переданный токен с токеном из базы данных
        if (!authToken.equals(storedToken)) {
            // Переданный токен не совпадает с токеном из базы данных, считаем его недействительным
            return false;
        }
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            LOGGER.error("Токен истек: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.error("Неподдерживаемый JWT токен: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.error("Некорректный JWT токен: {}", e.getMessage());
        } catch (SignatureException e) {
            LOGGER.error("Неверная подпись JWT токена: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT токен не может быть пустым или null: {}", e.getMessage());
        } catch (Exception e) {
            LOGGER.error("Неизвестная ошибка при валидации JWT токена: {}", e.getMessage());
        }
        return false;
    }

}
