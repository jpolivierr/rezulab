package com.appvenir.resumehelper.domain.jobListings.model;

import java.time.LocalDate;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.company.model.Company;
import com.appvenir.resumehelper.domain.payRange.model.PayRange;
import com.appvenir.resumehelper.domain.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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

    private boolean isUrgent;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Company company;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PayRange payRange;

}
