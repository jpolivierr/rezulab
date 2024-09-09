package com.appvenir.resumehelper.domain.promptGenerator.model;

import java.util.List;

import lombok.Data;

@Data
public class PromptAttribute {
    private List<Long> experienceIds;

    private Long promptId;

    private String jobDescription;
}
