package com.appvenir.rezulab.domain.promptGenerator.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.appvenir.rezulab.domain.experience.dto.ExperienceDto;
import com.appvenir.rezulab.domain.experience.mapper.ExperienceMapper;
import com.appvenir.rezulab.domain.experience.repository.ExperienceRepository;
import com.appvenir.rezulab.domain.prompt.dto.PromptDto;
import com.appvenir.rezulab.domain.prompt.factory.PromptFactory;
import com.appvenir.rezulab.domain.prompt.mapper.PromptMapper;
import com.appvenir.rezulab.domain.prompt.repository.PromptRepository;
import com.appvenir.rezulab.domain.promptGenerator.model.PromptAttribute;
import com.appvenir.rezulab.domain.promptGenerator.model.PromptDetails;
import com.appvenir.rezulab.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.rezulab.domain.resumeTemplate.mapper.ResumeTemplateMapper;
import com.appvenir.rezulab.domain.resumeTemplate.repository.ResumeTemplateRepository;
import com.appvenir.rezulab.domain.user.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromptGeneratorService {
    
    private final UserService userService;
    private final ExperienceRepository experienceRepository;
    private final ResumeTemplateRepository resumeTemplateRepository;
    private final PromptRepository promptRepository;

    @Transactional
    public String generatePrompt(String email, PromptDetails promptDetails)
    {
        var user = userService.findUserByEmail(email);
        var userId = user.getId();

        List<ExperienceDto> experiences = experienceRepository
                                        .findByIdInAndUser(promptDetails.getExperienceIds(), user)
                                        .stream().map((e) -> {
                                            return ExperienceMapper.toDto(e);
                                        }).collect(Collectors.toList());
                                        
        ResumeTemplateDto resumeTemplateDto = resumeTemplateRepository
                                        .findByIdAndUserId(promptDetails.getResumeTemplateId(), userId)
                                        .map(ResumeTemplateMapper::toDto)
                                        .orElseThrow(() -> new EntityNotFoundException("Resume Template not found")); 
                                        
        PromptDto promptDto = promptRepository.findByIdAndUserId(promptDetails.getPromptId(), userId)
                                              .map(PromptMapper::toDto)
                                              .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));  
                                              
        return PromptFactory.getResumeTemplatePrompt(promptDto, experiences, resumeTemplateDto).build();

    }

    @Transactional
    public String generatePromptForJobDescription(String email, PromptAttribute promptAttribute)
    {
        var user = userService.findUserByEmail(email);
        var userId = user.getId();

        List<ExperienceDto> experiences = experienceRepository
                                        .findByIdInAndUser(promptAttribute.getExperienceIds(), user)
                                        .stream().map((e) -> {
                                            return ExperienceMapper.toDto(e);
                                        }).collect(Collectors.toList());;
                                        
        ResumeTemplateDto resumeTemplateDto = new ResumeTemplateDto();
        resumeTemplateDto.setJobDescription(promptAttribute.getJobDescription());
                                        
        PromptDto promptDto = promptRepository.findByIdAndUserId(promptAttribute.getPromptId(), userId)
                                              .map(PromptMapper::toDto)
                                              .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));  
                                              
        return PromptFactory.getResumeTemplatePrompt(promptDto, experiences, resumeTemplateDto).build();

    }
  

}
