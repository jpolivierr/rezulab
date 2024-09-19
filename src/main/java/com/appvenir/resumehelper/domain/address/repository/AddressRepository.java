package com.appvenir.resumehelper.domain.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.resumehelper.domain.address.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
