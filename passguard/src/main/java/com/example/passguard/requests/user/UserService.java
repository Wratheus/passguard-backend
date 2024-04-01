package com.example.passguard.requests.user;

import com.example.passguard.DTO.EntityDTOMapper;
import com.example.passguard.DTO.UserDTO;
import com.example.passguard.models.Response;
import com.example.passguard.models.User;
import com.example.passguard.repositories.DAO.UserEntityDAO;
import com.example.passguard.repositories.DAO.UserPasswordDAO;
import com.example.passguard.repositories.entities.UserEntity;
import com.example.passguard.repositories.entities.UserPasswordEntity;
import com.example.passguard.util.JWTTokenProvider;
import com.example.passguard.util.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.HttpURLConnection;
import java.time.Instant;
import java.util.Optional;

import static com.example.passguard.PassguardApplication.UserServiceLogger;

@Service
public class UserService {
    final private UserEntityDAO userDAO;
    final private UserPasswordDAO userPasswordDAO;
    final private JWTTokenProvider tokenProvider;


    @Autowired
    public UserService(UserEntityDAO userDao, UserPasswordDAO userPasswordDAO, JWTTokenProvider tokenProvider) {
        this.userDAO = userDao;
        this.userPasswordDAO = userPasswordDAO;
        this.tokenProvider = tokenProvider;
    }

    public Response getUser(GetUserRequest request) {
        Optional<String> userIdNullable = tokenProvider.validateToken(request.token());
        if (userIdNullable.isEmpty()) {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    "Failed token validation");
        }

        long userId;
        try {
            userId = Long.parseLong(userIdNullable.get());
        } catch (NumberFormatException e) {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    "Failed to parse userId to Long");
        }

        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isEmpty()) {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    "User not found");
        }
        UserServiceLogger.info(user.get().toString());
        UserDTO userDTO = EntityDTOMapper.convertUserToUserDto(user.get());
        UserServiceLogger.info(userDTO.toString());
        return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK,
                new User(userDTO.getId(), userDTO.getEmail(), userDTO.getUsername()));
    }

    @Transactional
    public Response registerUser(RegisterUserRequest request) {
        Instant date = Instant.now();
        // Запись юзера
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(request.email());
        userEntity.setUsername(request.username());
        userEntity.setDate(date.toEpochMilli());
        userEntity = userDAO.save(userEntity);
        // Запись пароля
        UserPasswordEntity passwordEntity = new UserPasswordEntity();
        passwordEntity.setPassword(request.password());
        passwordEntity.setDate(date.toEpochMilli());
        passwordEntity.setUserId(userEntity.getId());
        userPasswordDAO.save(passwordEntity);
        // Запись JWT
        String accessToken = tokenProvider.generateToken(userEntity.getId());

        return new Response(
                ResponseConstants.SUCCESS,
                HttpURLConnection.HTTP_OK,
                accessToken);
    }
}
