package com.appvenir.rezulab.domain.jobListings.mapper;

import com.appvenir.rezulab.domain.company.mapper.CompanyMapper;
import com.appvenir.rezulab.domain.jobListings.dto.JobListingDto;
import com.appvenir.rezulab.domain.jobListings.model.JobListing;
import com.appvenir.rezulab.domain.payRange.mapper.PayRangeMapper;

public class JobListingMapper {
 
    public static JobListingDto toDto(JobListing jobListing)
    {
        var jobListingDto = new JobListingDto();
        jobListingDto.setId(jobListing.getId());
        jobListingDto.setCompany(CompanyMapper.toDto(jobListing.getCompany()));
        jobListingDto.setJobTitle(jobListing.getJobTitle());
        jobListingDto.setJobDescription(jobListing.getJobDescription());
        jobListingDto.setJobType(jobListing.getJobType());
        jobListingDto.setDatePosted(jobListing.getDatePosted());
        jobListingDto.setPayRange(PayRangeMapper.toDto(jobListing.getPayRange()));
        jobListingDto.setSource(jobListing.getSource());
        jobListingDto.setStatus(jobListing.getStatus());
        jobListingDto.setWorkSetting(jobListing.getWorkSetting());
        jobListingDto.setUrgent(jobListing.isUrgent());
        jobListingDto.setDateCreated(jobListing.getDateCreated());
        jobListingDto.setLastUpdated(jobListing.getLastUpdated());
        return jobListingDto;
    }

    public static JobListing toEntity(JobListingDto jobListingDto)
    {
        var jobListing = new JobListing();
        jobListing.setCompany(CompanyMapper.toEntity(jobListingDto.getCompany()));
        jobListing.setJobTitle(jobListingDto.getJobTitle());
        jobListing.setJobDescription(jobListingDto.getJobDescription());
        jobListing.setJobType(jobListingDto.getJobType());
        jobListing.setDatePosted(jobListingDto.getDatePosted());
        jobListing.setPayRange(PayRangeMapper.toEntity(jobListingDto.getPayRange()));
        jobListing.setSource(jobListingDto.getSource());
        jobListing.setStatus(jobListingDto.getStatus());
        jobListing.setWorkSetting(jobListingDto.getWorkSetting());
        jobListing.setUrgent(jobListingDto.isUrgent());
        return jobListing;
    }


}
