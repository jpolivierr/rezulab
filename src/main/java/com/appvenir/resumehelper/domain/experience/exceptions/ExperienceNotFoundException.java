package com.appvenir.resumehelper.domain.experience.exceptions;

public class ExperienceNotFoundException extends RuntimeException {
    
    public ExperienceNotFoundException()
    {
        super("Experience was not found");
    }

}
