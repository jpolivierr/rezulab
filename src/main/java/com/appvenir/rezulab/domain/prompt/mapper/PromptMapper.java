package com.appvenir.rezulab.domain.prompt.mapper;

import com.appvenir.rezulab.domain.prompt.dto.PromptDto;
import com.appvenir.rezulab.domain.prompt.model.Prompt;
import com.appvenir.rezulab.domain.user.model.User;

public class PromptMapper {

    public static Prompt toEntityWithUser(User user, PromptDto promptDto)
    {
        Prompt prompt = new Prompt();
        prompt.setName(promptDto.getName());
        prompt.setContext(promptDto.getContext());
        prompt.setInstructions(String.join(", ", promptDto.getInstructions()));
        prompt.setConstraints(String.join(", ",promptDto.getConstraints()));
        prompt.setScope(promptDto.getScope());
        prompt.setAudience(promptDto.getAudience());
        prompt.setExamples(promptDto.getExamples());
        prompt.setUserId(user.getId());
        return prompt;
    }

    public static PromptDto toDto(Prompt prompt)
    {
        PromptDto promptDto = new PromptDto();
        promptDto.setId(prompt.getId());
        promptDto.setName(prompt.getName());
        promptDto.setContext(prompt.getContext());
        promptDto.setStringInstructions(prompt.getInstructions());
        promptDto.setStringConstraints(prompt.getConstraints());
        promptDto.setScope(prompt.getScope());
        promptDto.setAudience(prompt.getAudience());
        promptDto.setExamples(prompt.getExamples());
        return promptDto;

    }
    
}
