package com.appvenir.resumehelper.domain.experience.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExperienceDto {

    private Long id;

    private String company;

    private String jobTitle;

    private String jobDescription;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;
}
