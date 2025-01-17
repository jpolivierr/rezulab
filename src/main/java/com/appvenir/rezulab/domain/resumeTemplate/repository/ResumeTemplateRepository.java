package com.appvenir.rezulab.domain.resumeTemplate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.rezulab.domain.resumeTemplate.model.ResumeTemplate;
import com.appvenir.rezulab.domain.user.model.User;

@Repository
public interface ResumeTemplateRepository extends JpaRepository<ResumeTemplate, Long> {
    Optional<ResumeTemplate> findByIdAndUser(Long resumeTemplateId, User user);
    Optional<ResumeTemplate> findByIdAndUserId(Long resumeTemplateId, Long userId);
}
