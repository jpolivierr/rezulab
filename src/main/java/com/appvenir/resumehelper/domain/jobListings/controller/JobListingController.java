package com.appvenir.resumehelper.domain.jobListings.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.resumehelper.domain.jobListings.dto.JobListingDto;
import com.appvenir.resumehelper.domain.jobListings.service.JobListingService;
import com.appvenir.resumehelper.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/job-listings")
@RequiredArgsConstructor
public class JobListingController {

    private final JobListingService jobListingService;

    @PostMapping
    public ResponseData<JobListingDto> createJobListing(
        @RequestBody JobListingDto jobListingObject,
        @RequestParam("email") String email)
        {
            var jobListing = jobListingService.createJobListing(email, jobListingObject);
            return ResponseData.set(jobListing);
        }
    
    @GetMapping
    public ResponseData<List<JobListingDto>> getAllJobListing(
        @RequestParam("email") String email)
        {
            var jobListings = jobListingService.getAllJobListing(email);
            return ResponseData.set(jobListings);
        }
}
