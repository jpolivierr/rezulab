package com.appvenir.rezulab.domain.prompt.controller;

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

import com.appvenir.rezulab.domain.prompt.dto.PromptDto;
import com.appvenir.rezulab.domain.prompt.service.PromptService;
import com.appvenir.rezulab.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/prompts")
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<PromptDto> createPrompt(
        @RequestBody PromptDto promptDto,
        @RequestParam("email") String email
        )
    {
        var prompt = promptService.createPrompt(email, promptDto);
        return ResponseData.set(prompt);
    }

    @GetMapping("/{promptId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<PromptDto> getPrompt(
        @PathVariable Long promptId,
        @RequestParam("email") String email
        )
    {
        var prompt = promptService.getUserPromptById(email, promptId);
        return ResponseData.set(prompt);
    }

    @PutMapping("/{promptId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<PromptDto> updatePrompt(
        @PathVariable Long promptId,
        @RequestBody PromptDto promptDto,
        @RequestParam("email") String email
        )
    {
        var prompt = promptService.updatePrompt(email, promptId, promptDto);
        return ResponseData.set(prompt);
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
