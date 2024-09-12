package com.appvenir.resumehelper.domain.company.model;

import com.appvenir.resumehelper.domain.address.model.Address;
import com.appvenir.resumehelper.domain.common.Auditable;
import com.appvenir.resumehelper.domain.contactNumber.model.ContactNumber;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Company extends Auditable{
    
    @Column(nullable = false)
    private String name;

    private String about;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contact_number_id", referencedColumnName = "id")
    private ContactNumber contactNumber;


}
