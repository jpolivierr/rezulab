package com.appvenir.resumehelper.domain.user.model;

import java.util.Set;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.experience.model.Experience;
import com.appvenir.resumehelper.domain.resumeTemplate.model.ResumeTemplate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Set<ResumeTemplate> resumeTemplates;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experience> experiences;

}
