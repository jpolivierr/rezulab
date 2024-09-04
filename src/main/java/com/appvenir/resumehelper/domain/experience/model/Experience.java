package com.appvenir.resumehelper.domain.experience.model;

import java.time.LocalDate;
import java.util.Set;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.resumeTemplate.model.ResumeTemplate;
import com.appvenir.resumehelper.domain.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Experience extends Auditable{

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}