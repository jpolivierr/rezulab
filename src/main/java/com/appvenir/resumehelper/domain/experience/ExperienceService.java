package com.appvenir.resumehelper.domain.experience;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.user.User;
import com.appvenir.resumehelper.domain.user.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final UserService userService;
    private final ExperienceMapper experienceMapper;
    private final ExperienceRepository experienceRepository;

    @Transactional
    public ExperienceDto addExperience(String email, ExperienceDto experienceDto)
    {
        User user = userService.findUserByEmail(email);
        Experience experience = experienceMapper.toEntity(experienceDto);
        experience.setUser(user);
        Experience savedExperience = experienceRepository.save(experience);
        user.getExperiences().add(savedExperience);
        userService.saveUser(user);
        return experienceMapper.toDto(savedExperience);
    }

    @Transactional
    public List<ExperienceDto> addExperiences(String email, List<ExperienceDto> experienceDtos) {
        User user = userService.findUserByEmail(email);
        List<Experience> experiences = experienceDtos.stream()
                .map(dto -> {
                    Experience experience = experienceMapper.toEntity(dto);
                    experience.setUser(user);
                    return experience;
                })
                .collect(Collectors.toList());
        List<Experience> savedExperiences = experienceRepository.saveAll(experiences);
        user.getExperiences().addAll(savedExperiences);
        userService.saveUser(user);
        return experienceMapper.toDtoList(savedExperiences);
    }
}
    

