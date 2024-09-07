package com.appvenir.resumehelper.domain.experience.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.experience.exceptions.ExperienceNotFoundException;
import com.appvenir.resumehelper.domain.experience.mapper.ExperienceMapper;
import com.appvenir.resumehelper.domain.experience.model.Experience;
import com.appvenir.resumehelper.domain.experience.repository.ExperienceRepository;
import com.appvenir.resumehelper.domain.user.model.User;
import com.appvenir.resumehelper.domain.user.service.UserService;

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
        return experienceMapper.toDto(savedExperience);
    }

    @Transactional
    public List<ExperienceDto> addExperiences(String email, List<ExperienceDto> experienceDtos)
    {
        User user = userService.findUserByEmail(email);
        List<Experience> experiences = experienceMapper.toEntityListWithUser(user, experienceDtos);

        List<Experience> savedExperiences = experienceRepository.saveAll(experiences);
        return experienceMapper.toDtoList(savedExperiences);
    }

    @Transactional
    public ExperienceDto getUserExperienceById(String email, Long experienceId)
    {
        User user = userService.findUserByEmail(email);
        Experience experience = experienceRepository.findByIdAndUserId(experienceId, user.getId()).orElseThrow(() -> new ExperienceNotFoundException());
        return experienceMapper.toDto(experience);
    }

    @Transactional
    public List<ExperienceDto> getAllUserExperiences(String email)
    {
        User user = userService.findUserByEmail(email);
        List<Experience> experiences = experienceRepository.findAllByUserId(user.getId());
        System.out.println(experiences);
        return experienceMapper.toDtoList(experiences);
    }

    @Transactional
    private Experience findUserExperienceById(String email, Long experienceId)
    {
        User user = userService.findUserByEmail(email);
        return experienceRepository.findByIdAndUserId(experienceId, user.getId()).orElseThrow(() -> new ExperienceNotFoundException());
    }

    @Transactional
    public ExperienceDto updateExperience(String email, Long experienceId, ExperienceDto experienceDto)
    {
        Experience experience = findUserExperienceById(email, experienceId);
        experience.setCompany(experienceDto.getCompany());
        experience.setJobTitle(experienceDto.getJobTitle());
        experience.setJobDescription(experienceDto.getJobDescription());
        experience.setStartDate(experience.getStartDate());
        experience.setEndDate(experience.getEndDate());
        return experienceMapper.toDto(experience);
    }

    @Transactional
    public void deleteExperience(String email, Long experienceId)
    {
        Experience experience = findUserExperienceById(email, experienceId);
        experienceRepository.delete(experience);
       
    }

    @Transactional
    public void deleteAllExperiences(String email)
    {
        User user = userService.findUserByEmail(email);
        experienceRepository.deleteAllExperiencesByUserId(user.getId());
    }


}
    

