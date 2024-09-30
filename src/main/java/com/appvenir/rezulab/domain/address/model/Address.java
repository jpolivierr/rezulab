package com.appvenir.rezulab.domain.address.model;

import com.appvenir.rezulab.domain.common.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "address")
@Data
@EqualsAndHashCode(callSuper = false)
public class Address extends Auditable {
    
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipCode;

}
