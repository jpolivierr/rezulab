package com.appvenir.resumehelper.domain.user;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.experience.Experience;
import com.appvenir.resumehelper.domain.experience.ExperienceMapper;
import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ExperienceMapper experienceMapper;

    public UserDto saveUser(UserRegistrationDto userRegistrationDto){
        User user = userMapper.toEntity(userRegistrationDto);
        return userMapper.toDto(userRepository.save(user));
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email)
                        .orElseThrow(() -> new EntityNotFoundException("A user was not found"));
    }

    @Transactional
    public void addExperience(UserDto userDto, ExperienceDto experienceDto){
        User user = findUserByEmail(userDto.getEmail());
        user.addExperience(experienceMapper.toEntity(experienceDto));
        userRepository.save(user);
    }

    @Transactional
    public void removeExperiencese (UserDto userDto, Long experienceId)
    {
        User user = findUserByEmail(userDto.getEmail());
        user.removeExperienceById(experienceId);
        userRepository.save(user);
    }

    @Transactional
    public void updateExperience (UserDto userDto, Long experiencId, ExperienceDto newExperience)
    {
        User user = findUserByEmail(userDto.getEmail());
        user.updateExperience(experiencId, newExperience);
        userRepository.save(user);
    }
    
}
