package com.appvenir.rezulab.domain.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.rezulab.domain.company.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>  {
    
}
