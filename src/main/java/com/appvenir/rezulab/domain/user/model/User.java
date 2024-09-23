package com.appvenir.rezulab.domain.user.model;

import java.util.Set;

import com.appvenir.rezulab.domain.common.Auditable;
import com.appvenir.rezulab.domain.company.model.Company;
import com.appvenir.rezulab.domain.experience.model.Experience;
import com.appvenir.rezulab.domain.jobListings.model.JobListing;
import com.appvenir.rezulab.domain.resumeTemplate.model.ResumeTemplate;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
public class User extends Auditable{
    
    @Column(name = "full_name", nullable = false)         
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResumeTemplate> resumeTemplates = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experience> experiences = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Company> companies = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobListing> jobListings = new ArrayList<>();

    public void addJobListing (JobListing jobListing)
    {
        jobListings.add(jobListing);
        jobListing.setUser(this);
    }

    public void removeJobListing (JobListing jobListing)
    {
        jobListings.remove(jobListing);
        jobListing.setUser(null);
    }

    public void addCompany(Company company)
    {
        companies.add(company);
        company.setUser(this);
    }

    public void removeComapany(Company company)
    {
        companies.remove(company);
        company.setUser(null);
    }

}
