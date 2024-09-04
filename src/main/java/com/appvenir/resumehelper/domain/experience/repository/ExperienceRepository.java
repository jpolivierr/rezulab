package com.appvenir.resumehelper.domain.experience.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appvenir.resumehelper.domain.experience.model.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    Optional<Experience> findByIdAndUserId(Long experienceId, Long userId);
    List<Experience> findAllByUserId(Long userId);
    void deleteAllExperiencesByUserId(Long userId);
}
