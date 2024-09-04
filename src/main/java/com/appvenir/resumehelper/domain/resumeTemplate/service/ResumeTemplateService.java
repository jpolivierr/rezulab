package com.appvenir.resumehelper.domain.resumeTemplate.service;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.resumehelper.domain.resumeTemplate.mapper.ResumeTemplateMapper;
import com.appvenir.resumehelper.domain.resumeTemplate.model.ResumeTemplate;
import com.appvenir.resumehelper.domain.resumeTemplate.repository.ResumeTemplateRepository;
import com.appvenir.resumehelper.domain.user.model.User;
import com.appvenir.resumehelper.domain.user.service.UserService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeTemplateService {
     
    private final ResumeTemplateMapper resumeTemplateMapper;
    private final UserService userService;
    private final ResumeTemplateRepository resumeTemplateRepository;
    
    @Transactional
    public ResumeTemplateDto createResumeTemplate(String email, ResumeTemplateDto resumeTemplateDto)
    {
        User user = userService.findUserByEmail(email);
        ResumeTemplate resumeTemplate = resumeTemplateMapper.toEntity(resumeTemplateDto);
        resumeTemplate.setUser(user);
        ResumeTemplate savedResumeTemplate = resumeTemplateRepository.save(resumeTemplate);
        return resumeTemplateMapper.toDto(savedResumeTemplate);
    }

    @Transactional
    public ResumeTemplateDto getUserResumeTemplate(String email, Long resumeTemplateId)
    {
        User user = userService.findUserByEmail(email);
        ResumeTemplate resumeTemplate = resumeTemplateRepository.findByIdAndUser(resumeTemplateId, user)
                .orElseThrow(() -> new EntityNotFoundException("Resume Template not found"));

        return resumeTemplateMapper.toDto(resumeTemplate);
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

        if(!resumeTemplate.getName().equals(resumeTemplateDto.getName()))
        {
            resumeTemplateRepository.findByNameAndUser(email, user)
                .ifPresent((r) -> {throw new EntityExistsException("Template name already exists.");});
        }
        resumeTemplate.setName(resumeTemplateDto.getName());
        resumeTemplate.setDescription(resumeTemplateDto.getDescription());
        resumeTemplate.setSampleResume(resumeTemplateDto.getSampleResume());
        resumeTemplate.setJobDescription(resumeTemplateDto.getJobDescription());
        ResumeTemplate savedResumeTemplate = resumeTemplateRepository.save(resumeTemplate);
        
        return resumeTemplateMapper.toDto(savedResumeTemplate);
    }

    @Transactional
    public void deleteUserResumeTemplate(String email, Long resumeTemplateId)
    {
        ResumeTemplate resumeTemplate = findUserResumeTemplate(email, resumeTemplateId);
        resumeTemplateRepository.delete(resumeTemplate);
    }
  
    
}
