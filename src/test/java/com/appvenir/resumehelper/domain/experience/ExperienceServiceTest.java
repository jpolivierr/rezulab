package com.appvenir.resumehelper.domain.experience;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.appvenir.rezulab.domain.experience.factory.ExperienceFactory;
import com.appvenir.rezulab.domain.experience.mapper.ExperienceMapper;
import com.appvenir.rezulab.domain.experience.model.Experience;
import com.appvenir.rezulab.domain.experience.repository.ExperienceRepository;
import com.appvenir.rezulab.domain.experience.service.ExperienceService;
import com.appvenir.rezulab.domain.user.factory.UserFactory;
import com.appvenir.rezulab.domain.user.model.User;
import com.appvenir.rezulab.domain.user.service.UserService;

public class ExperienceServiceTest {

    private UserService userService;
    private ExperienceRepository experienceRepository;
    private ExperienceService experienceService;

    @BeforeEach
    public void setUp()
    {
        this.userService = mock(UserService.class);
        this.experienceRepository = mock(ExperienceRepository.class);
        this.experienceService = new ExperienceService(userService, experienceRepository);
    }

    @Test
    public void addExperience_should_save_experience()
    {
        User user = UserFactory.getUser();
        var experience = ExperienceFactory.getExperience();
        var experienceDto = ExperienceMapper.toDto(experience);

        when(userService.findUserByEmail(anyString())).thenReturn(user);
        when(experienceRepository.save(any(Experience.class))).thenReturn(experience);

        var result = experienceService.addExperience(user.getEmail(), experienceDto);

        assertNotNull(result);
        verify(userService, times(1)).findUserByEmail(user.getEmail());
        verify(experienceRepository, times(1)).save(any(Experience.class));
    }
    
}
