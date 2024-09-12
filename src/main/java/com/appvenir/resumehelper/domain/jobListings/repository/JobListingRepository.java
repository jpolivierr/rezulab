package com.appvenir.resumehelper.domain.jobListings.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appvenir.resumehelper.domain.jobListings.model.JobListing;

public interface JobListingRepository extends JpaRepository<JobListing,Long> {
    
}
