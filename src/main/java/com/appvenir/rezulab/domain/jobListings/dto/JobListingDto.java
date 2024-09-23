package com.appvenir.rezulab.domain.jobListings.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.appvenir.rezulab.domain.company.dto.CompanyDto;
import com.appvenir.rezulab.domain.payRange.dto.PayRangeDto;

import lombok.Data;

@Data
public class JobListingDto {

    private Long id;
        
    private String jobTitle;

    private String jobDescription;

    private String jobType;

    private LocalDate datePosted;

    private String workSetting;

    private String status;

    private String source;

    private boolean urgent;

    private CompanyDto company;

    private PayRangeDto payRange;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;

}
