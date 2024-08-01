package com.appvenir.resumehelper.domain.user;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto saveUser(UserRegistrationDto userRegistrationDto){
        User user = userMapper.toEntity(userRegistrationDto);
        return userMapper.toDto(userRepository.save(user));
    }
    
}
