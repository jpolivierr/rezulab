package com.appvenir.resumehelper.domain.resumeTemplate.model;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "resume_template")
public class ResumeTemplate extends Auditable {

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description")
    private String description;

    @Column(name = "sample_resume")
    private String sampleResume;

    @Column(name = "job_description")
    private String jobDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
