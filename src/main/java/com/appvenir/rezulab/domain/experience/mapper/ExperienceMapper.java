package com.appvenir.rezulab.domain.experience.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.appvenir.rezulab.domain.experience.dto.ExperienceDto;
import com.appvenir.rezulab.domain.experience.model.Experience;
import com.appvenir.rezulab.domain.user.model.User;

public class ExperienceMapper {

    public static ExperienceDto toDto(Experience e)
    {
        ExperienceDto experience = new ExperienceDto();
        experience.setId(e.getId());
        experience.setCompany(e.getCompany());
        experience.setJobTitle(e.getJobTitle());
        experience.setJobDescription(e.getJobDescription());
        experience.setStartDate(e.getStartDate());
        experience.setEndDate(e.getEndDate());
        experience.setDateCreated(e.getDateCreated());
        experience.setLastUpdated(e.getLastUpdated());
        return experience;
    }
    
    public static Experience toEntity(ExperienceDto e){
        Experience experience = new Experience();
        experience.setId(experience.getId());
        experience.setCompany(e.getCompany());
        experience.setJobTitle(e.getJobTitle());
        experience.setJobDescription(e.getJobDescription());
        experience.setStartDate(e.getStartDate());
        experience.setEndDate(e.getEndDate());
        return experience;
    }

    public static List<ExperienceDto> toDtoList(List<Experience> experiences)
    {
        return experiences.stream().map(e -> {
            ExperienceDto experience = new ExperienceDto();
            experience.setId(e.getId());
            experience.setCompany(e.getCompany());
            experience.setJobTitle(e.getJobTitle());
            experience.setJobDescription(e.getJobDescription());
            experience.setStartDate(e.getStartDate());
            experience.setEndDate(e.getEndDate());
            experience.setDateCreated(e.getDateCreated());
            experience.setLastUpdated(e.getLastUpdated());
            return experience;
        }).collect(Collectors.toList());
    }

    // List<Experience> toEntityList(List<ExperienceDto> experienceDtos);

    public static List<Experience> toEntityListWithUser(User user, List<ExperienceDto> experienceDtos){
        return experienceDtos.stream().map((e) -> {
            Experience experience = new Experience();
            experience.setCompany(e.getCompany());
            experience.setJobTitle(e.getJobTitle());
            experience.setJobDescription(e.getJobDescription());
            experience.setStartDate(e.getStartDate());
            experience.setEndDate(e.getEndDate());
            experience.setUser(user);
            return experience;
        }).collect(Collectors.toList());
    }
}
