package com.appvenir.resumehelper.domain.user.mapper;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;
import com.appvenir.resumehelper.domain.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    User toEntity(UserRegistrationDto userDto);
}