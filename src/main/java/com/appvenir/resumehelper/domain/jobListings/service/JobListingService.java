package com.appvenir.resumehelper.domain.jobListings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.jobListings.dto.JobListingDto;
import com.appvenir.resumehelper.domain.jobListings.mapper.JobListingMapper;
import com.appvenir.resumehelper.domain.jobListings.repository.JobListingRepository;
import com.appvenir.resumehelper.domain.user.service.UserService;

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
        jobListing.setUser(user);
        var savedJobListing = jobListingRepository.save(jobListing);
        return JobListingMapper.toDto(savedJobListing);
    }

    @Transactional
    public List<JobListingDto> getAllJobListing(String email)
    {
        var user = userService.findUserByEmail(email);
        var jobListing = jobListingRepository.findAllByUserEmail(user.getEmail());
        return jobListing.stream().map(j -> JobListingMapper.toDto(j)).toList();
    }
}
