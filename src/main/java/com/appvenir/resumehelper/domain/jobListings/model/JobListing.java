package com.appvenir.resumehelper.domain.jobListings.model;

import java.time.LocalDate;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.company.model.Company;
import com.appvenir.resumehelper.domain.payRange.model.PayRange;
import com.appvenir.resumehelper.domain.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "job_listings")
@Data
@EqualsAndHashCode(callSuper=false)
public class JobListing extends Auditable {
    
    private String jobTitle;

    private String jobDescription;

    private String jobType;

    private LocalDate datePosted;

    private String workSetting;

    private String status;

    private String source;

    @Column(name = "is_urgent")
    private boolean urgent;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(mappedBy = "jobListing", cascade = CascadeType.ALL, orphanRemoval = true)
    private Company company;

    @OneToOne(mappedBy = "jobListing", cascade = CascadeType.ALL, orphanRemoval = true)
    private PayRange payRange;

}
