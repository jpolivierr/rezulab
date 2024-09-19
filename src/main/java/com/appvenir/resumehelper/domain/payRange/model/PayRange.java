package com.appvenir.resumehelper.domain.payRange.model;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.jobListings.model.JobListing;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pay_range")
@Data
@EqualsAndHashCode(callSuper=false)
public class PayRange extends Auditable {

    private Integer min;

    private Integer max;
    
    private String period;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_listing_id", nullable = false)
    private JobListing jobListing;
}
