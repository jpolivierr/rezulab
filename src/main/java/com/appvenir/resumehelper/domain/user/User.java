package com.appvenir.resumehelper.domain.user;

import java.util.Set;

import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.experience.Experience;
import com.appvenir.resumehelper.domain.experience.dto.ExperienceDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
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
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Experience> experiences;

    public void addExperience(Experience experience){
        experiences.add(experience);
        experience.setUser(this);
    }

    public void removeExperience(Experience experience){
        experiences.remove(experience);
        experience.setUser(null);
    }

    public void removeExperienceById(Long id){
        experiences.removeIf( experience -> {
            if(experience.getId().equals(id)){
                experience.setUser(null);
                return true;
            }
            return false;
        });
    }

    public void updateExperience(Long id, ExperienceDto newExperienceDto){
        Experience experience = experiences.stream()
            .filter(exp -> exp.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new EntityNotFoundException("Experience not found"));

        experience.setCompany(newExperienceDto.getCompany());
        experience.setJobDescription(newExperienceDto.getJobDescription());
        experience.setJobTitle(newExperienceDto.getJobTitle());
        experience.setStartDate(newExperienceDto.getStartDate());
        experience.setEndDate(newExperienceDto.getEndDate());
    }
    

}
