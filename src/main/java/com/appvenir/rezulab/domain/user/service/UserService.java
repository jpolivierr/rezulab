package com.appvenir.rezulab.domain.user.service;

import org.springframework.stereotype.Service;

import com.appvenir.rezulab.domain.user.dto.UserDto;
import com.appvenir.rezulab.domain.user.dto.UserRegistrationDto;
import com.appvenir.rezulab.domain.user.mapper.UserMapper;
import com.appvenir.rezulab.domain.user.model.User;
import com.appvenir.rezulab.domain.user.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto saveUser(UserRegistrationDto userRegistrationDto){
        User user = UserMapper.toEntity(userRegistrationDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email)
                        .orElseThrow(() -> new EntityNotFoundException("A user was not found"));
    }
    
}
