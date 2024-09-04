package com.appvenir.resumehelper.domain.user.service;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.experience.mapper.ExperienceMapper;
import com.appvenir.resumehelper.domain.experience.model.Experience;
import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;
import com.appvenir.resumehelper.domain.user.mapper.UserMapper;
import com.appvenir.resumehelper.domain.user.model.User;
import com.appvenir.resumehelper.domain.user.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email)
                        .orElseThrow(() -> new EntityNotFoundException("A user was not found"));
    }
    
}
