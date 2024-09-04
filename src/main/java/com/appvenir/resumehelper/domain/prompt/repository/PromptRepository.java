package com.appvenir.resumehelper.domain.prompt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.resumehelper.domain.prompt.model.Prompt;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, Long> {
    Optional<Prompt> findByIdAndUserId(Long promptId, Long UserId);
    Optional<Prompt> findByNameAndUserId(String promptName, Long UserId);
}
