package com.appvenir.resumehelper.admin.domain.promptGenerator.model;

import java.util.List;
import lombok.Data;

@Data
public class PromptDetails {

    private List<Long> experienceIds;

    private Long resumeTemplateId;

    private Long promptId;

}
