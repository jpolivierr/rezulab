package com.appvenir.rezulab.domain.contactNumber.model;

import com.appvenir.rezulab.domain.common.Auditable;
import com.appvenir.rezulab.domain.company.model.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table( name = "contact_number")
@Data
@EqualsAndHashCode(callSuper = false)
public class ContactNumber extends Auditable {
    
    private String type;

    private String ext;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
