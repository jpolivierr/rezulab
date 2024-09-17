package com.appvenir.resumehelper.domain.jobListings.dto;

import com.appvenir.resumehelper.domain.company.dto.CompanyDto;
import com.appvenir.resumehelper.domain.payRange.dto.PayRangeDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private boolean isUrgent;

    private CompanyDto company;

    private PayRangeDto payRange;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;

}
