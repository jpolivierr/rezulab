package com.appvenir.rezulab.domain.resumeTemplate.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResumeTemplateDto {
    private Long id;
    private String sampleResume;
    private String jobDescription;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
