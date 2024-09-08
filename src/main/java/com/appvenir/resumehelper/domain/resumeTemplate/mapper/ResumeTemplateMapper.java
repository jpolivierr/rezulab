package com.appvenir.resumehelper.domain.resumeTemplate.mapper;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.resumehelper.domain.resumeTemplate.model.ResumeTemplate;

@Mapper(componentModel = "spring")
public interface ResumeTemplateMapper {

    default ResumeTemplateDto toDto (ResumeTemplate resumeTemplate)
    {
        var resumeTemplateDto = new ResumeTemplateDto();
        resumeTemplateDto.setId(resumeTemplate.getId());
        resumeTemplateDto.setName(resumeTemplate.getName());
        resumeTemplateDto.setDescription(resumeTemplate.getDescription());
        resumeTemplateDto.setJobDescription(resumeTemplate.getJobDescription());
        resumeTemplate.setSampleResume(resumeTemplate.getSampleResume());
        resumeTemplate.setDateCreated(resumeTemplate.getDateCreated());
        resumeTemplate.setDateCreated(resumeTemplate.getDateCreated());
        return resumeTemplateDto;
    }

    default ResumeTemplate toEntity(ResumeTemplateDto resumeTemplateDto)
    {
        var resumeTemplate = new ResumeTemplate();
        resumeTemplate.setName(resumeTemplateDto.getName());
        resumeTemplate.setDescription(resumeTemplateDto.getDescription());
        resumeTemplate.setJobDescription(resumeTemplateDto.getJobDescription());
        resumeTemplate.setSampleResume(resumeTemplateDto.getSampleResume());
        return resumeTemplate;
    }
    
}
