package com.appvenir.rezulab.domain.promptGenerator.model;

import java.util.List;
import lombok.Data;

@Data
public class PromptDetails {

    private List<Long> experienceIds;

    private Long resumeTemplateId;

    private Long promptId;

}
