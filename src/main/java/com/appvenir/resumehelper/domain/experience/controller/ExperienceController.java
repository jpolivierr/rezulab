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
import com.appvenir.resumehelper.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData addExperience(
        @RequestBody ExperienceDto experienceDto,
        @RequestParam("email") String email
        )
    {
        var experience = experienceService.addExperience(email, experienceDto);
        return new ResponseData(experience);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData addExperiences(
        @RequestBody List<ExperienceDto> experienceDtos,
        @RequestParam("email") String email
        )
    {
        var experiences = experienceService.addExperiences(email, experienceDtos);
        return new ResponseData(experiences);
    }

    @GetMapping("/{experienceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData getExperience(
        @PathVariable Long experienceId,
        @RequestParam("email") String email
        )
    {
        var experience = experienceService.getUserExperienceById(email, experienceId);
        return new ResponseData(experience);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseData getAllExperiences(
        @RequestParam("email") String email
        )
    {
        var experiences = experienceService.getAllUserExperiences(email);
        return new ResponseData(experiences);
    }

    @PutMapping("/{experienceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData updateExperience(
        @PathVariable Long experienceId,
        @RequestBody ExperienceDto experienceDto,
        @RequestParam("email") String email
        )
    {
        var experience = experienceService.updateExperience(email, experienceId, experienceDto);
        return new ResponseData(experience);
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
