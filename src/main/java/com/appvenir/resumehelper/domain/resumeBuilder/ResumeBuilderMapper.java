package com.appvenir.resumehelper.domain.resumeBuilder;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.resumeBuilder.dto.ResumeBuilderDto;

@Mapper(componentModel = "spring")
public interface ResumeBuilderMapper {

    ResumeBuilderDto toDto (ResumeBuilder resumeBuilder);
    ResumeBuilder toEntity(ResumeBuilderDto resumeBuilderDto);
    
}
