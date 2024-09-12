package com.appvenir.resumehelper.domain.payRange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appvenir.resumehelper.domain.payRange.model.PayRange;

public interface PayRangeRepository extends JpaRepository<PayRange, Long> {
    
}
