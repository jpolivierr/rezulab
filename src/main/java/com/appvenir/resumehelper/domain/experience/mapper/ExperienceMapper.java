package com.appvenir.resumehelper.domain.experience.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;
import com.appvenir.resumehelper.domain.experience.model.Experience;
import com.appvenir.resumehelper.domain.user.model.User;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

    default ExperienceDto toDto(Experience e)
    {
        ExperienceDto experience = new ExperienceDto();
        experience.setId(e.getId());
        experience.setCompany(e.getCompany());
        experience.setJobTitle(e.getJobTitle());
        experience.setJobDescription(e.getJobDescription());
        experience.setStartDate(e.getStartDate());
        experience.setEndDate(e.getEndDate());
        return experience;
    }
    
    default Experience toEntity(ExperienceDto e){
        Experience experience = new Experience();
        experience.setId(experience.getId());
        experience.setCompany(e.getCompany());
        experience.setJobTitle(e.getJobTitle());
        experience.setJobDescription(e.getJobDescription());
        experience.setStartDate(e.getStartDate());
        experience.setEndDate(e.getEndDate());
        return experience;
    }

    default List<ExperienceDto> toDtoList(List<Experience> experiences)
    {
        return experiences.stream().map(e -> {
            ExperienceDto experience = new ExperienceDto();
            experience.setId(experience.getId());
            experience.setCompany(e.getCompany());
            experience.setJobTitle(e.getJobTitle());
            experience.setJobDescription(e.getJobDescription());
            experience.setStartDate(e.getStartDate());
            experience.setEndDate(e.getEndDate());
            return experience;
        }).toList();
    }

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
