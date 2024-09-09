package com.appvenir.resumehelper.domain.resumeTemplate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.resumehelper.domain.resumeTemplate.service.ResumeTemplateService;
import com.appvenir.resumehelper.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resume_templates")
@RequiredArgsConstructor
public class ResumeTemplateController {

    private final ResumeTemplateService resumeTemplateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createResumeTemplate(
        @RequestParam("email") String email,
        @RequestBody ResumeTemplateDto resumeTemplateDto
    ){
        var resumeTemplate = resumeTemplateService.createResumeTemplate(email, resumeTemplateDto);
        return ResponseEntity.ok(new ResponseData(HttpStatus.CREATED.value(), resumeTemplate));
    }

    @GetMapping("/{resumeTemplateId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getResumeTemplate(
        @RequestParam("email") String email,
        @PathVariable("resumeTemplateId") Long resumeTemplateId
    ){
        var resumeTemplate = resumeTemplateService.getUserResumeTemplate(email, resumeTemplateId);
        return ResponseEntity.ok(new ResponseData(HttpStatus.OK.value(), resumeTemplate));
    }

    @PutMapping("/{resumeTemplateId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateResumeTemplate(
        @RequestParam("email") String email,
        @PathVariable("resumeTemplateId") Long resumeTemplateId,
        @RequestBody ResumeTemplateDto resumeTemplateDto
    ){
        var resumeTemplate = resumeTemplateService.updateResumeTemplate(email, resumeTemplateId, resumeTemplateDto);
        return ResponseEntity.ok(new ResponseData(HttpStatus.OK.value(), resumeTemplate));
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
