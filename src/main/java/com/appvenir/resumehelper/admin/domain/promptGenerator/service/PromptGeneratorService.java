package com.appvenir.resumehelper.admin.domain.promptGenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.admin.domain.promptGenerator.model.PromptDetails;
import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.experience.mapper.ExperienceMapper;
import com.appvenir.resumehelper.domain.experience.repository.ExperienceRepository;
import com.appvenir.resumehelper.domain.prompt.dto.PromptDto;
import com.appvenir.resumehelper.domain.prompt.factory.PromptFactory;
import com.appvenir.resumehelper.domain.prompt.mapper.PromptMapper;
import com.appvenir.resumehelper.domain.prompt.repository.PromptRepository;
import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.resumehelper.domain.resumeTemplate.mapper.ResumeTemplateMapper;
import com.appvenir.resumehelper.domain.resumeTemplate.repository.ResumeTemplateRepository;
import com.appvenir.resumehelper.domain.user.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromptGeneratorService {
    
    private final UserService userService;
    private final ExperienceRepository experienceRepository;
    private final ExperienceMapper experienceMapper;
    private final ResumeTemplateRepository resumeTemplateRepository;
    private final ResumeTemplateMapper resumeTemplateMapper;
    private final PromptRepository promptRepository;
    private final PromptMapper promptMapper;

    @Transactional
    public String generatePrompt(String email, PromptDetails promptDetails)
    {
        var user = userService.findUserByEmail(email);
        var userId = user.getId();

        List<ExperienceDto> experiences = experienceRepository
                                        .findByIdInAndUser(promptDetails.getExperienceIds(), user)
                                        .stream().map((e) -> {
                                            return experienceMapper.toDto(e);
                                        }).toList();
        
        ResumeTemplateDto resumeTemplateDto = resumeTemplateRepository
                                        .findByIdAndUserId(promptDetails.getResumeTemplateId(), userId)
                                        .map(resumeTemplateMapper::toDto)
                                        .orElseThrow(() -> new EntityNotFoundException("Resume Template not found")); 
                                        
        PromptDto promptDto = promptRepository.findByIdAndUserId(promptDetails.getPromptId(), userId)
                                              .map(promptMapper::toDto)
                                              .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));  
                                              
        return PromptFactory.getResumeTemplatePrompt(promptDto, experiences, resumeTemplateDto).build();

    }
  

}
