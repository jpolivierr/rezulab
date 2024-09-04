package com.appvenir.resumehelper.domain.experience.controller;

import java.util.List;

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

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.experience.service.ExperienceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExperienceDto addExperience(
        @RequestBody ExperienceDto experienceDto,
        @RequestParam("email") String email
        )
    {
        return experienceService.addExperience(email, experienceDto);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ExperienceDto> addExperiences(
        @RequestBody List<ExperienceDto> experienceDtos,
        @RequestParam("email") String email
        )
    {
        return experienceService.addExperiences(email, experienceDtos);
    }

    @GetMapping("/{experienceId}")
    @ResponseStatus(HttpStatus.OK)
    public ExperienceDto getExperience(
        @PathVariable Long experienceId,
        @RequestParam("email") String email
        )
    {
        return experienceService.getUserExperienceById(email, experienceId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExperienceDto> getAllExperiences(
        @RequestParam("email") String email
        )
    {
        return experienceService.getAllUserExperiences(email);
    }

    @PutMapping("/{experienceId}")
    @ResponseStatus(HttpStatus.OK)
    public ExperienceDto updateExperience(
        @PathVariable Long experienceId,
        @RequestBody ExperienceDto experienceDto,
        @RequestParam("email") String email
        )
    {
        return experienceService.updateExperience(email, experienceId, experienceDto);
    }

    @DeleteMapping("/{experienceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(
        @PathVariable Long experienceId,
        @RequestParam("email") String email
        )
    {
         experienceService.deleteExperience(email, experienceId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllExperience(
        @RequestParam("email") String email
        )
    {
         experienceService.deleteAllExperiences(email);
    }
    
}
