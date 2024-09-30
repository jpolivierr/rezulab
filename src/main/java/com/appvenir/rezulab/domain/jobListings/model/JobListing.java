package com.appvenir.rezulab.domain.jobListings.model;

import java.time.LocalDate;

import com.appvenir.rezulab.domain.common.Auditable;
import com.appvenir.rezulab.domain.company.model.Company;
import com.appvenir.rezulab.domain.payRange.model.PayRange;
import com.appvenir.rezulab.domain.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pay_range_id")
    private PayRange payRange;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
