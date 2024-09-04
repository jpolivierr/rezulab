package com.appvenir.resumehelper.domain.prompt.controller;

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

import com.appvenir.resumehelper.domain.prompt.dto.PromptDto;
import com.appvenir.resumehelper.domain.prompt.service.PromptService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prompts")
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PromptDto createPrompt(
        @RequestBody PromptDto promptDto,
        @RequestParam("email") String email
        )
    {
        return promptService.createPrompt(email, promptDto);
    }

    @GetMapping("/{promptId}")
    @ResponseStatus(HttpStatus.OK)
    public PromptDto getPrompt(
        @PathVariable Long promptId,
        @RequestParam("email") String email
        )
    {
        return promptService.getUserPromptById(email, promptId);
    }

    @PutMapping("/{promptId}")
    @ResponseStatus(HttpStatus.OK)
    public PromptDto updatePrompt(
        @PathVariable Long promptId,
        @RequestBody PromptDto promptDto,
        @RequestParam("email") String email
        )
    {
        return promptService.updatePrompt(email, promptId, promptDto);
    }

    @DeleteMapping("/{promptId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrompt(
        @PathVariable Long promptId,
        @RequestParam("email") String email
        )
    {
        promptService.deleteUserPromptById(email, promptId);
    }
    
}