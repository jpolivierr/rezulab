package com.appvenir.resumehelper.domain.resumeBuilder;

import java.util.HashSet;
import java.util.Set;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.experience.Experience;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "resumeBuilder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experience> experiences = new HashSet<>();

    public void addExperience(Experience experience) {
        experiences.add(experience);
        experience.setResumeBuilder(this);
    }

    public void removeExperience(Experience experience) {
        experiences.remove(experience);
        experience.setResumeBuilder(null);
    }

}
