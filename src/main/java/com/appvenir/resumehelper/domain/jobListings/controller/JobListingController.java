package com.appvenir.resumehelper.domain.jobListings.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.resumehelper.domain.jobListings.model.JobListing;
import com.appvenir.resumehelper.domain.jobListings.service.JobListingService;
import com.appvenir.resumehelper.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/job-listings")
@RequiredArgsConstructor
public class JobListingController {

    private final JobListingService jobListingService;

    @PostMapping
    public ResponseData<JobListing> createJobListing(
        @RequestBody JobListing jobListingObject,
        @RequestParam("email") String email)
        {
            var jobListing = jobListingService.createJobListing(email, jobListingObject);
            return ResponseData.set(jobListing);
        }
    
}
