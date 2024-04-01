package com.example.passguard.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
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

    @Autowired
    public JWTTokenProvider(@Value("${app.jwtSecret}") String jwtSecret) {
        this.jwtSecret = jwtSecret;
        this.secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    public Optional<String> validateToken(String authToken) {
        try {
            // Разбор токена и получение его тела (payload)
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(authToken)
                    .getBody();

            // Получение userId из тела токена
            String userId = claims.getSubject();

            // Возвращение userId как Optional
            return Optional.of(userId);
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

        // Если не удалось извлечь userId из токена, возвращаем пустой Optional
        return Optional.empty();
    }
}
