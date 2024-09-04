package com.appvenir.resumehelper.domain.experience.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.experience.model.Experience;
import com.appvenir.resumehelper.domain.user.model.User;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    ExperienceDto toDto(Experience experience);
    
    Experience toEntity(ExperienceDto experienceDto); 

    List<ExperienceDto> toDtoList(List<Experience> experiences);

    List<Experience> toEntityList(List<ExperienceDto> experienceDtos);

    default List<Experience> toEntityListWithUser(User user, List<ExperienceDto> experienceDtos){
        return experienceDtos.stream().map((e) -> {
            Experience experience = new Experience();
            experience.setCompany(e.getCompany());
            experience.setJobTitle(e.getJobTitle());
            experience.setJobDescription(e.getJobDescription());
            experience.setStartDate(e.getStartDate());
            experience.setEndDate(e.getEndDate());
            experience.setUser(user);
            return experience;
        }).toList();
    }
}
