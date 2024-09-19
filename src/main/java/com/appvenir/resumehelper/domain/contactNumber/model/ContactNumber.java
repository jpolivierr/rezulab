package com.appvenir.resumehelper.domain.contactNumber.model;

import com.appvenir.resumehelper.domain.common.Auditable;

import jakarta.persistence.Entity;
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

}
