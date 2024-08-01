package com.appvenir.resumehelper.domain.resumeBuilder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeBuilderRepository extends JpaRepository<ResumeBuilder, Long> {
    
}
