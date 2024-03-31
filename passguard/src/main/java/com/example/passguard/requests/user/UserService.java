package com.example.passguard.requests.user;

import com.example.passguard.DTO.EntityDTOMapper;
import com.example.passguard.DTO.TokenDTO;
import com.example.passguard.DTO.UserDTO;
import com.example.passguard.models.Response;
import com.example.passguard.models.User;
import com.example.passguard.repositories.DAO.GenericDAO;
import com.example.passguard.repositories.DAO.TokenDAO;
import com.example.passguard.repositories.entities.TokenEntity;
import com.example.passguard.repositories.entities.UserEntity;
import com.example.passguard.requests.user.get.GetUserRequest;
import com.example.passguard.requests.user.get.RegisterUserRequest;
import com.example.passguard.util.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserService {
    final private GenericDAO<UserEntity, Long> userDAO;
    final private TokenDAO tokenDAO;

    @Autowired
    public UserService(GenericDAO<UserEntity, Long> userDao, TokenDAO tokenDAO) {
        this.userDAO = userDao;
        this.tokenDAO = tokenDAO;
    }

    public Response getUser(GetUserRequest request) {
        long userId = request.getId();
        UserEntity user = userDAO.findById(UserEntity.class, userId);
        UserDTO userDTO = EntityDTOMapper.convertUserToUserDto(user);

        TokenEntity token = tokenDAO.findById(TokenEntity.class, userDTO.getId());
        TokenDTO tokenDTO = EntityDTOMapper.convertTokenToUserDto(token);

        if (request.getToken().equals(tokenDTO.getToken())) {
            return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK,
                    new User(1, "23", "123"));
        } else {
            return new Response(ResponseConstants.ERROR, HttpURLConnection.HTTP_CONFLICT,
                    null);
        }
    }

    public Response registerUser(RegisterUserRequest request) {
        userDAO.save(new UserEntity(1231231L, request.getEmail(), request.getPassword(),
                System.currentTimeMillis()));

        return new Response(ResponseConstants.SUCCESS, HttpURLConnection.HTTP_OK,
                getUser(new GetUserRequest(1, "123")));
    }
}
