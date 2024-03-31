package com.example.passguard.requests.user;

import com.example.passguard.DTO.EntityDTOMapper;
import com.example.passguard.DTO.TokenDTO;
import com.example.passguard.DTO.UserDTO;
import com.example.passguard.models.Response;
import com.example.passguard.models.User;
import com.example.passguard.repositories.DAO.TokenEntityDAO;
import com.example.passguard.repositories.DAO.UserEntityDAO;
import com.example.passguard.repositories.DAO.UserPasswordDAO;
import com.example.passguard.repositories.entities.TokenEntity;
import com.example.passguard.repositories.entities.UserEntity;
import com.example.passguard.repositories.entities.UserPasswordEntity;
import com.example.passguard.requests.user.get.GetUserRequest;
import com.example.passguard.requests.user.get.RegisterUserRequest;
import com.example.passguard.util.JWTTokenProvider;
import com.example.passguard.util.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.HttpURLConnection;
import java.util.Optional;

@Service
public class UserService {
    final private TokenEntityDAO tokenDAO;
    final private UserEntityDAO userDAO;
    final private UserPasswordDAO userPasswordDAO;
    final private JWTTokenProvider tokenProvider;


    @Autowired
    public UserService(UserEntityDAO userDao, TokenEntityDAO tokenDAO, UserPasswordDAO userPasswordDAO, JWTTokenProvider tokenProvider) {
        this.userDAO = userDao;
        this.tokenDAO = tokenDAO;
        this.userPasswordDAO = userPasswordDAO;
        this.tokenProvider = tokenProvider;
    }

    public Response getUser(GetUserRequest request) {
        long userId = request.getId();

        Optional<UserEntity> user = userDAO.findById(userId);
        if (user.isEmpty()) {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    "Object not found");
        }
        UserDTO userDTO = EntityDTOMapper.convertUserToUserDto(user.get());

        Optional<TokenEntity> token = tokenDAO.findById(userDTO.getId());
        if (token.isEmpty()) {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    "Object not found");
        }
        TokenDTO tokenDTO = EntityDTOMapper.convertTokenToUserDto(token.get());

        if (request.getToken().equals(tokenDTO.getToken())) {
            return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK,
                    new User(1, "alex-pavlenko-net-2013@yandex.ru", "wratheus"));
        } else {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    null);
        }
    }

    @Transactional
    public Response registerUser(RegisterUserRequest request) {
        long date = System.currentTimeMillis();
        // Запись юзера
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(request.getEmail());
        userEntity.setUsername(request.getUsername());
        userEntity.setDate(date);
        userEntity = userDAO.save(userEntity);
        // Запись пароля
        UserPasswordEntity passwordEntity = new UserPasswordEntity();
        passwordEntity.setPassword(request.getPassword());
        passwordEntity.setDate(date);
        passwordEntity.setUserId(userEntity.getId());
        userPasswordDAO.save(passwordEntity);
        // Запись JWT
        String accessToken = tokenProvider.generateToken(userEntity.getUsername());
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken(accessToken);
        tokenEntity.setDate(date);
        tokenEntity.setUserId(userEntity.getId());
        tokenEntity = tokenDAO.save(tokenEntity);


        return new Response(
                ResponseConstants.SUCCESS,
                HttpURLConnection.HTTP_OK,
                tokenEntity);
    }
}
