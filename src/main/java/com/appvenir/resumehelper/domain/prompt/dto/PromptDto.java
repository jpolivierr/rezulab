package com.appvenir.resumehelper.domain.prompt.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PromptDto {
    private Long id;
    private String name;
    private String context;
    private String instructions;
    private String constraints;
    private String scope;
    private String audience;
    private String examples;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
    
}
