package com.appvenir.resumehelper.domain.resumeBuilder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.experience.Experience;
import com.appvenir.resumehelper.domain.resumeBuilder.dto.ResumeBuilderDto;
import com.appvenir.resumehelper.domain.user.User;
import com.appvenir.resumehelper.domain.user.UserService;
import com.appvenir.resumehelper.domain.user.dto.UserDto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeBuilderService {
     
    private final ResumeBuilderMapper resumeBuilderMapper;
    private final UserService userService;

    @Transactional
    public void saveResumeBuilder(UserDto userDto, ResumeBuilderDto resumeBuilderDto){
        User user = userService.findUserByEmail(userDto.getEmail());
        user.addResumeBuilder(resumeBuilderMapper.toEntity(resumeBuilderDto));
        userService.saveUser(user);
    }

    @Transactional
    public void addExperiences(String email, Long resumeBuilderId, List<Long> experienceIds) {

        if(experienceIds.size() == 0) return;
        User user = userService.findUserByEmail(email);
        ResumeBuilder resumeBuilder = user.getResumeBuilders().stream()
                                .filter(r -> r.getId().equals(resumeBuilderId))
                                .findFirst()
                                .orElseThrow(() -> new EntityNotFoundException("A resume builder was not found"));

        List<Experience> experiences = user.getExperiences().stream()
        .filter(e -> experienceIds.contains(e.getId()))
        .collect(Collectors.toList());
                    
        if (experiences.size() != experienceIds.size()) {
            throw new EntityNotFoundException("One or more experiences not found");
        }                

        experiences.forEach(resumeBuilder::addExperience);
        userService.saveUser(user);

    }
    
}
