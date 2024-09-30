package com.appvenir.rezulab.domain.company.model;

import java.util.ArrayList;
import java.util.List;

import com.appvenir.rezulab.domain.address.model.Address;
import com.appvenir.rezulab.domain.common.Auditable;
import com.appvenir.rezulab.domain.contactNumber.model.ContactNumber;
import com.appvenir.rezulab.domain.jobListings.model.JobListing;
import com.appvenir.rezulab.domain.user.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactNumber> contactNumbers = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobListing> jobListings = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    public void addJobListing(JobListing jobListing)
    {
        if (jobListings.size() >= 10) {
            throw new IllegalStateException("A company cannot have more than 10 job listings.");
        }
        jobListings.add(jobListing);
        jobListing.setCompany(this);
    }

    public void removeJobListing(JobListing jobListing)
    {
        jobListings.remove(jobListing);
        jobListing.setCompany(null);
    }

    public void addContactNumber(ContactNumber contactNumber)
    {
        if(contactNumbers.size() > 5)
        {
            throw new IllegalStateException("A company cannot have more than 5 contact numbers");
        }

        contactNumbers.add(contactNumber);
        contactNumber.setCompany(this);
    }

    public void removeContactNumber(ContactNumber contactNumber)
    {
        contactNumbers.remove(contactNumber);
        contactNumber.setCompany(null);
    }

}
