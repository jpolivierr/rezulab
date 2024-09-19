package com.appvenir.resumehelper.domain.company.model;

import java.util.List;

import com.appvenir.resumehelper.domain.address.model.Address;
import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.contactNumber.model.ContactNumber;
import com.appvenir.resumehelper.domain.jobListings.model.JobListing;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Company extends Auditable{
    
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String about;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id") 
    private List<ContactNumber> contactNumbers;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_listing_id", nullable = false)
    private JobListing jobListing;

}
