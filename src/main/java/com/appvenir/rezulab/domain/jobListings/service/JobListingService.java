package com.appvenir.rezulab.domain.jobListings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvenir.rezulab.domain.contactNumber.model.ContactNumber;
import com.appvenir.rezulab.domain.jobListings.dto.JobListingDto;
import com.appvenir.rezulab.domain.jobListings.mapper.JobListingMapper;
import com.appvenir.rezulab.domain.jobListings.model.JobListing;
import com.appvenir.rezulab.domain.jobListings.repository.JobListingRepository;
import com.appvenir.rezulab.domain.payRange.mapper.PayRangeMapper;
import com.appvenir.rezulab.domain.user.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobListingService {

    private final JobListingRepository jobListingRepository;
    private final UserService userService;
    
    @Transactional
    public JobListingDto createJobListing(String email, JobListingDto jobListingDto)
    {
        var user = userService.findUserByEmail(email);
        var jobListing = JobListingMapper.toEntity(jobListingDto);
        var company = jobListing.getCompany();

        if(company != null)
        {
            user.addCompany(company);
            company.addJobListing(jobListing);
            
            if(company.getContactNumbers() != null && company.getContactNumbers().size() > 0 )
            {
                for(ContactNumber contactNumber : company.getContactNumbers()){
                    contactNumber.setCompany(company);
                }
            }
        }

        user.addJobListing(jobListing);
        var savedJobListing = jobListingRepository.save(jobListing);
        return JobListingMapper.toDto(savedJobListing);
    }

    @Transactional
    public JobListingDto updateJobListing(String email, Long jobListingId, JobListingDto jobListingDto)
    {
        var jobListing = findJobListing(email, jobListingId);

        if (jobListingDto.getJobTitle() != null) {
            jobListing.setJobTitle(jobListingDto.getJobTitle());
        }
        if (jobListingDto.getJobDescription() != null) {
            jobListing.setJobDescription(jobListingDto.getJobDescription());
        }
        if (jobListingDto.getJobType() != null) {
            jobListing.setJobType(jobListingDto.getJobType());
        }
        if (jobListingDto.getDatePosted() != null) {
            jobListing.setDatePosted(jobListingDto.getDatePosted());
        }
        if (jobListingDto.getWorkSetting() != null) {
            jobListing.setWorkSetting(jobListingDto.getWorkSetting());
        }
        if (jobListingDto.getStatus() != null) {
            jobListing.setStatus(jobListingDto.getStatus());
        }
        if (jobListingDto.getSource() != null) {
            jobListing.setSource(jobListingDto.getSource());
        }
        
        jobListing.setUrgent(jobListingDto.isUrgent());
    
        if (jobListingDto.getPayRange() != null) {
            jobListing.setPayRange(PayRangeMapper.toEntity(jobListingDto.getPayRange()));
        }
    
        var savedJobListing = jobListingRepository.save(jobListing);
        return JobListingMapper.toDto(savedJobListing);
    }

    @Transactional
    public JobListingDto getJobListing(String email, Long jobListingId)
    {
        var user = userService.findUserByEmail(email);
        var jobListing = jobListingRepository.findByIdAndUser(jobListingId, user)
        .orElseThrow(() -> new EntityNotFoundException("Job listing not found"));
        return JobListingMapper.toDto(jobListing);
    }

    @Transactional
    private JobListing findJobListing(String email, Long jobListingId)
    {
        var user = userService.findUserByEmail(email);
        var jobListing = jobListingRepository.findByIdAndUser(jobListingId, user)
        .orElseThrow(() -> new EntityNotFoundException("Job listing not found"));
        return jobListing;
    }

    @Transactional
    public List<JobListingDto> getAllJobListing(String email)
    {
        var user = userService.findUserByEmail(email);
        var jobListing = jobListingRepository.findAllByUserEmail(user.getEmail());
        return jobListing.stream().map(j -> JobListingMapper.toDto(j)).toList();
    }

    @Transactional
    public void deleteJobListing(String email, Long jobListingId)
    {
        var user = userService.findUserByEmail(email);
        var jobListing = jobListingRepository.findByIdAndUser(jobListingId, user)
        .orElseThrow(() -> new EntityNotFoundException("Job listing not found"));
        jobListingRepository.delete(jobListing);
    }
}
