package com.appvenir.resumehelper.domain.resumeBuilder;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeBuilderService {

    private final ResumeBuilderRepository resumeBuilderRepository;

    public ResumeBuilder saveResumeBuilder(ResumeBuilder resumeBuilder){
        return resumeBuilderRepository.save(resumeBuilder);
    }
    
}
