package com.appvenir.rezulab.domain.resumeTemplate.mapper;

import com.appvenir.rezulab.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.rezulab.domain.resumeTemplate.model.ResumeTemplate;

public class ResumeTemplateMapper {

    public static ResumeTemplateDto toDto (ResumeTemplate resumeTemplate)
    {
        var resumeTemplateDto = new ResumeTemplateDto();
        resumeTemplateDto.setId(resumeTemplate.getId());
        resumeTemplateDto.setName(resumeTemplate.getName());
        resumeTemplateDto.setJobDescription(resumeTemplate.getJobDescription());
        resumeTemplateDto.setSampleResume(resumeTemplate.getSampleResume());
        resumeTemplateDto.setDateCreated(resumeTemplate.getDateCreated());
        resumeTemplateDto.setLastUpdated(resumeTemplate.getLastUpdated());
        return resumeTemplateDto;
    }

    public static ResumeTemplate toEntity(ResumeTemplateDto resumeTemplateDto)
    {
        var resumeTemplate = new ResumeTemplate();
        resumeTemplate.setName(resumeTemplateDto.getName());
        resumeTemplate.setJobDescription(resumeTemplateDto.getJobDescription());
        resumeTemplate.setSampleResume(resumeTemplateDto.getSampleResume());
        return resumeTemplate;
    }
    
}
