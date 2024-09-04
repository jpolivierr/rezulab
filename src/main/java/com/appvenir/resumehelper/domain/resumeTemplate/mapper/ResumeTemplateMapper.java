package com.appvenir.resumehelper.domain.resumeTemplate.mapper;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.resumeTemplate.dto.ResumeTemplateDto;
import com.appvenir.resumehelper.domain.resumeTemplate.model.ResumeTemplate;

@Mapper(componentModel = "spring")
public interface ResumeTemplateMapper {

    ResumeTemplateDto toDto (ResumeTemplate resumeTemplate);
    ResumeTemplate toEntity(ResumeTemplateDto resumeTemplateDto);
    
}
