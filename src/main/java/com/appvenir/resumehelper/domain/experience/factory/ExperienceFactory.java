package com.appvenir.resumehelper.domain.experience.factory;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.appvenir.resumehelper.domain.experience.model.Experience;

public class ExperienceFactory {
    
    public static Experience getExperience()
    {
        var experience = new Experience();
        experience.setId(Long.valueOf(1));
        experience.setCompany("Company");
        experience.setJobDescription("This is the job description");
        experience.setJobTitle("Job Title");
        experience.setStartDate(LocalDate.now().minusWeeks(1));
        experience.setEndDate(LocalDate.now());
        experience.setDateCreated(LocalDateTime.now());
        experience.setLastUpdated(LocalDateTime.now());
        return experience;
    }

}
