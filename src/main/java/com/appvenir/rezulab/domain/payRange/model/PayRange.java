package com.appvenir.rezulab.domain.payRange.model;

import com.appvenir.rezulab.domain.common.Auditable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "pay_range")
@Data
@EqualsAndHashCode(callSuper=false)
public class PayRange extends Auditable {

    private Integer min;

    private Integer max;
    
    private String period;
}
