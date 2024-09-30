package com.appvenir.rezulab.domain.payRange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appvenir.rezulab.domain.payRange.model.PayRange;

public interface PayRangeRepository extends JpaRepository<PayRange, Long> {
    
}
