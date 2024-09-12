package com.appvenir.resumehelper.domain.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.resumehelper.domain.company.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>  {
    
}
