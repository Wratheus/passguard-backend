package com.example.passguard.DTO;

import com.example.passguard.models.Product;
import com.example.passguard.models.User;

public class EntityDtoMapper {

    public static UserDTO convertUserToUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.id());
        userDto.setUsername(user.username());
        userDto.setEmail(user.email());
        return userDto;
    }

    public static ProductDTO convertUserToUserDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setPassword(product.password());
        productDto.setLogin(product.login());
        return productDto;
    }
}
