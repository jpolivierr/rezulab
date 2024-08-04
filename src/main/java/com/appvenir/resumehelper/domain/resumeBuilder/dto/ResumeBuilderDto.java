package com.appvenir.resumehelper.domain.resumeBuilder.dto;

import java.util.HashSet;
import java.util.Set;

import com.appvenir.resumehelper.domain.experience.Experience;

import lombok.Data;

@Data
public class ResumeBuilderDto {
    private Long id;
    private String jobDescription;
    private Set<Experience> experiences = new HashSet<>();
}
