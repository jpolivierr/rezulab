package com.appvenir.resumehelper.domain.experience;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    ExperienceDto toDto(Experience experience);
    Experience toEntity(ExperienceDto experienceDto); 
}
