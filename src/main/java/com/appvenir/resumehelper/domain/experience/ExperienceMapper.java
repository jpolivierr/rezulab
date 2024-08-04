package com.appvenir.resumehelper.domain.experience;

import java.util.List;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    ExperienceDto toDto(Experience experience);
    List<ExperienceDto> toDtoList(List<Experience> experiences);
    Experience toEntity(ExperienceDto experienceDto); 
}
