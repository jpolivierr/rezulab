package com.appvenir.resumehelper.domain.prompt.service;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.prompt.dto.PromptDto;
import com.appvenir.resumehelper.domain.prompt.mapper.PromptMapper;
import com.appvenir.resumehelper.domain.prompt.model.Prompt;
import com.appvenir.resumehelper.domain.prompt.repository.PromptRepository;
import com.appvenir.resumehelper.domain.user.model.User;
import com.appvenir.resumehelper.domain.user.service.UserService;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromptService {
    
    private final PromptRepository promptRepository;
    private final UserService userService;

    @Transactional
    public PromptDto createPrompt(String email, PromptDto promptDto)
    {
        User user = userService.findUserByEmail(email);
        Prompt prompt = PromptMapper.toEntityWithUser(user, promptDto);
        Prompt savedPrompt = promptRepository.save(prompt);
        return PromptMapper.toDto(savedPrompt);
    }

    @Transactional
    public PromptDto getUserPromptById(String email, Long promptId)
    {
        User user = userService.findUserByEmail(email);
        Prompt prompt = promptRepository.findByIdAndUserId(promptId, user.getId())
            .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));
        return PromptMapper.toDto(prompt);
    }

    @Transactional
    private Prompt findUserPromptById(String email, Long promptId)
    {
        User user = userService.findUserByEmail(email);
        Prompt prompt = promptRepository.findByIdAndUserId(promptId, user.getId())
            .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));
        return prompt;
    }

    @Transactional
    private Prompt findUserPromptByName(String email, String promptName)
    {
        User user = userService.findUserByEmail(email);
        Prompt prompt = promptRepository.findByNameAndUserId(promptName, user.getId())
            .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));
        return prompt;
    }

    @Transactional
    private boolean promptNameAlreadyExists(String email, String promptName)
    {
        User user = userService.findUserByEmail(email);
        return promptRepository.findByNameAndUserId(promptName, user.getId()).isPresent();
    }

    @Transactional
    public PromptDto updatePrompt(String email, Long promptId, PromptDto promptDto)
    {
        User user = userService.findUserByEmail(email);
        Prompt prompt = promptRepository.findByIdAndUserId(promptId, user.getId())
            .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));
        
        if(!promptDto.getName().equals(prompt.getName())) {
           promptRepository.findByNameAndUserId(promptDto.getName(), user.getId())
            .ifPresent((p) -> {throw new EntityExistsException("Prompt name already exists");}); 
        }  
        prompt.setName(promptDto.getName());
        prompt.setContext(promptDto.getContext());
        prompt.setInstructions(promptDto.getInstructionsAsStrings());
        prompt.setConstraints(promptDto.getConstraintsAsStrings());
        prompt.setScope(promptDto.getScope());
        prompt.setAudience(promptDto.getAudience());
        prompt.setExamples(promptDto.getExamples());

        return PromptMapper.toDto(prompt);
    }

    @Transactional
    public void deleteUserPromptById(String email, Long promptId)
    {
        User user = userService.findUserByEmail(email);
        Prompt prompt = promptRepository.findByIdAndUserId(promptId, user.getId())
            .orElseThrow(() -> new EntityNotFoundException("Prompt not found"));
        promptRepository.delete(prompt);
    }

}
