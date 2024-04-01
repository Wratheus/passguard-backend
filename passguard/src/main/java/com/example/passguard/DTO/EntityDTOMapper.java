package com.example.passguard.DTO;

import com.example.passguard.repositories.entities.ProductEntity;
import com.example.passguard.repositories.entities.TokenEntity;
import com.example.passguard.repositories.entities.UserEntity;

public class EntityDTOMapper {

    public static UserDTO convertUserToUserDto(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public static ProductDTO convertProductToProductDto(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPassword(product.getPassword());
        productDTO.setLogin(product.getLogin());
        return productDTO;
    }
}
