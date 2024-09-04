package com.appvenir.resumehelper.domain.prompt.mapper;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.prompt.dto.PromptDto;
import com.appvenir.resumehelper.domain.prompt.model.Prompt;
import com.appvenir.resumehelper.domain.user.model.User;

@Mapper(componentModel = "spring")
public interface PromptMapper {

    Prompt toEntity(PromptDto promptDto);

    default Prompt toEntityWithUser(User user, PromptDto promptDto)
    {
        Prompt prompt = new Prompt();
        prompt.setName(promptDto.getName());
        prompt.setContext(promptDto.getContext());
        prompt.setInstructions(promptDto.getInstructions());
        prompt.setConstraints(promptDto.getConstraints());
        prompt.setScope(promptDto.getScope());
        prompt.setAudience(promptDto.getAudience());
        prompt.setExamples(promptDto.getExamples());
        prompt.setUserId(user.getId());
        return prompt;
    }
    PromptDto toDto(Prompt prompt);
    
}
