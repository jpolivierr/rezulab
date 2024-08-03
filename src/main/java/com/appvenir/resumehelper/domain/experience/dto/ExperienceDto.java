package com.appvenir.resumehelper.domain.experience.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExperienceDto {

    private Long id;

    private String company;

    private String jobTitle;

    private String jobDescription;

    private LocalDate startDate;

    private LocalDate endDate;
}
