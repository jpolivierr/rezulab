package com.appvenir.resumehelper.domain.resumeTemplate.mapper;

import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.resumehelper.domain.resumeTemplate.model.ResumeTemplate;

public class ResumeTemplateMapper {

    public static ResumeTemplateDto toDto (ResumeTemplate resumeTemplate)
    {
        var resumeTemplateDto = new ResumeTemplateDto();
        resumeTemplateDto.setId(resumeTemplate.getId());
        resumeTemplateDto.setJobDescription(resumeTemplate.getJobDescription());
        resumeTemplateDto.setSampleResume(resumeTemplate.getSampleResume());
        resumeTemplateDto.setDateCreated(resumeTemplate.getDateCreated());
        resumeTemplateDto.setLastUpdated(resumeTemplate.getLastUpdated());
        return resumeTemplateDto;
    }

    public static ResumeTemplate toEntity(ResumeTemplateDto resumeTemplateDto)
    {
        var resumeTemplate = new ResumeTemplate();
        resumeTemplate.setJobDescription(resumeTemplateDto.getJobDescription());
        resumeTemplate.setSampleResume(resumeTemplateDto.getSampleResume());
        return resumeTemplate;
    }
    
}
