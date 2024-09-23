package com.appvenir.resumehelper.domain.jobListings.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appvenir.resumehelper.domain.jobListings.model.JobListing;
import com.appvenir.resumehelper.domain.user.model.User;

public interface JobListingRepository extends JpaRepository<JobListing,Long> {
    List<JobListing> findAllByUserEmail(String email);
    Optional<JobListing> findByIdAndUser(Long id, User user);
    void deleteByIdAndUser(Long id, User user);
}
