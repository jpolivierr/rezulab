package com.appvenir.resumehelper.domain.jobListings.service;

import org.springframework.stereotype.Service;

import com.appvenir.resumehelper.domain.company.repository.CompanyRepository;
import com.appvenir.resumehelper.domain.jobListings.model.JobListing;
import com.appvenir.resumehelper.domain.jobListings.repository.JobListingRepository;
import com.appvenir.resumehelper.domain.payRange.model.PayRange;
import com.appvenir.resumehelper.domain.payRange.repository.PayRangeRepository;
import com.appvenir.resumehelper.domain.user.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobListingService {

    private final JobListingRepository jobListingRepository;
    private final PayRangeRepository payRangeRepository;
    private final CompanyRepository companyRepository;
    private final UserService userService;
    
    @Transactional
    public JobListing createJobListing(String email, JobListing jobListing)
    {
        var user = userService.findUserByEmail(email);
        jobListing.setUser(user);
        return jobListingRepository.save(jobListing);
    }
}
