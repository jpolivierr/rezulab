package com.appvenir.resumehelper.domain.resumeBuilder;

import java.util.HashSet;
import java.util.Set;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.experience.Experience;
import com.appvenir.resumehelper.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "resume_builder")
public class ResumeBuilder extends Auditable {
    
    @Column(name = "job_description", nullable = false)
    private String jobDescription;

    @ManyToMany
    @JoinTable(
        name = "resume_builder_experience",
        joinColumns = @JoinColumn( name = "resume_builder_id"),
        inverseJoinColumns = @JoinColumn(name = "experience_id")
    )
    private Set<Experience> experiences = new HashSet<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void addExperience(Experience experience) {
        if (user.getExperiences().contains(experience)) {
            experiences.add(experience);
        } else {
            throw new IllegalArgumentException("Experience must be associated with the user");
        }
    }

}
