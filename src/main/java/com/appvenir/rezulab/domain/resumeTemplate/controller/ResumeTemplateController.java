package com.appvenir.rezulab.domain.resumeTemplate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.rezulab.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.rezulab.domain.resumeTemplate.service.ResumeTemplateService;
import com.appvenir.rezulab.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resume_templates")
@RequiredArgsConstructor
public class ResumeTemplateController {

    private final ResumeTemplateService resumeTemplateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<ResumeTemplateDto> createResumeTemplate(
        @RequestParam("email") String email,
        @RequestBody ResumeTemplateDto resumeTemplateDto
    ){
        var resumeTemplate = resumeTemplateService.createResumeTemplate(email, resumeTemplateDto);
        return ResponseData.set(resumeTemplate);
    }

    @GetMapping("/{resumeTemplateId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<ResumeTemplateDto> getResumeTemplate(
        @RequestParam("email") String email,
        @PathVariable("resumeTemplateId") Long resumeTemplateId
    ){
        var resumeTemplate = resumeTemplateService.getUserResumeTemplate(email, resumeTemplateId);
        return ResponseData.set(resumeTemplate);
    }

    @PutMapping("/{resumeTemplateId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<ResumeTemplateDto> updateResumeTemplate(
        @RequestParam("email") String email,
        @PathVariable("resumeTemplateId") Long resumeTemplateId,
        @RequestBody ResumeTemplateDto resumeTemplateDto
    ){
        var resumeTemplate = resumeTemplateService.updateResumeTemplate(email, resumeTemplateId, resumeTemplateDto);
        return ResponseData.set(resumeTemplate);
    }

    @DeleteMapping("/{resumeTemplateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteResumeTemplate(
        @RequestParam("email") String email,
        @PathVariable("resumeTemplateId") Long resumeTemplateId
    ){
         resumeTemplateService.deleteUserResumeTemplate(email, resumeTemplateId);
    }
    
}
