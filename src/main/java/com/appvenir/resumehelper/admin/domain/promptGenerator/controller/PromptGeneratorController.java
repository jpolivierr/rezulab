package com.appvenir.resumehelper.admin.domain.promptGenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.resumehelper.admin.domain.promptGenerator.model.PromptDetails;
import com.appvenir.resumehelper.admin.domain.promptGenerator.service.PromptGeneratorService;
import com.appvenir.resumehelper.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/generate_prompt")
@RequiredArgsConstructor
public class PromptGeneratorController {

    private final PromptGeneratorService promptGeneratorService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<String> generatePrompt(@RequestBody PromptDetails promptDetails, @RequestParam("email") String email)
    {
        String finalPrompt = promptGeneratorService.generatePrompt(email, promptDetails);
        return ResponseData.set(finalPrompt);
    }
    
}
