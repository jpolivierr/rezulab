package com.appvenir.rezulab.domain.resumeTemplate.service;

import org.springframework.stereotype.Service;

import com.appvenir.rezulab.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.rezulab.domain.resumeTemplate.mapper.ResumeTemplateMapper;
import com.appvenir.rezulab.domain.resumeTemplate.model.ResumeTemplate;
import com.appvenir.rezulab.domain.resumeTemplate.repository.ResumeTemplateRepository;
import com.appvenir.rezulab.domain.user.model.User;
import com.appvenir.rezulab.domain.user.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeTemplateService {
     
    private final UserService userService;
    private final ResumeTemplateRepository resumeTemplateRepository;
    
    @Transactional
    public ResumeTemplateDto createResumeTemplate(String email, ResumeTemplateDto resumeTemplateDto)
    {
        User user = userService.findUserByEmail(email);
        ResumeTemplate resumeTemplate = ResumeTemplateMapper.toEntity(resumeTemplateDto);
        resumeTemplate.setUser(user);
        ResumeTemplate savedResumeTemplate = resumeTemplateRepository.save(resumeTemplate);
        return ResumeTemplateMapper.toDto(savedResumeTemplate);
    }

    @Transactional
    public ResumeTemplateDto getUserResumeTemplate(String email, Long resumeTemplateId)
    {
        User user = userService.findUserByEmail(email);
        ResumeTemplate resumeTemplate = resumeTemplateRepository.findByIdAndUser(resumeTemplateId, user)
                .orElseThrow(() -> new EntityNotFoundException("Resume Template not found"));

        return ResumeTemplateMapper.toDto(resumeTemplate);
    }

    @Transactional
    private ResumeTemplate findUserResumeTemplate(String email, Long resumeTemplateId)
    {
        User user = userService.findUserByEmail(email);
        return resumeTemplateRepository.findByIdAndUser(resumeTemplateId, user)
        .orElseThrow(() -> new EntityNotFoundException("Resume Template not found"));
    }

    @Transactional
    public ResumeTemplateDto updateResumeTemplate(String email, Long resumeTemplateId, ResumeTemplateDto resumeTemplateDto)
    {
   
        User user = userService.findUserByEmail(email);
        ResumeTemplate resumeTemplate = resumeTemplateRepository.findByIdAndUser(resumeTemplateId, user)
        .orElseThrow(() -> new EntityNotFoundException("Resume Template not found"));
  
        resumeTemplate.setSampleResume(resumeTemplateDto.getSampleResume());
        resumeTemplate.setJobDescription(resumeTemplateDto.getJobDescription());
        ResumeTemplate savedResumeTemplate = resumeTemplateRepository.save(resumeTemplate);
        
        return ResumeTemplateMapper.toDto(savedResumeTemplate);
    }

    @Transactional
    public void deleteUserResumeTemplate(String email, Long resumeTemplateId)
    {
        ResumeTemplate resumeTemplate = findUserResumeTemplate(email, resumeTemplateId);
        resumeTemplateRepository.delete(resumeTemplate);
    }
  
    
}
