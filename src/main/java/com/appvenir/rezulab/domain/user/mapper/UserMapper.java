package com.appvenir.rezulab.domain.user.mapper;

import com.appvenir.rezulab.domain.user.dto.UserDto;
import com.appvenir.rezulab.domain.user.dto.UserRegistrationDto;
import com.appvenir.rezulab.domain.user.model.User;

public class UserMapper {

    public static UserDto toDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setFullName(user.getFullName());
        userDto.setEmail(user.getEmail());
        userDto.setDateCreated(user.getDateCreated());
        userDto.setLastUpdated(user.getLastUpdated());
        return userDto;
    }
    
    public static User toEntity(UserDto userDto)
    {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public static User toEntity(UserRegistrationDto userDto)
    {
        User user = new User();
        user.setFullName(userDto.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}