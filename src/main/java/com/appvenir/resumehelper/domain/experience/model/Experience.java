package com.appvenir.resumehelper.domain.experience.model;

import java.time.LocalDate;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.user.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "experiences")
@ToString(exclude = "user")
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
