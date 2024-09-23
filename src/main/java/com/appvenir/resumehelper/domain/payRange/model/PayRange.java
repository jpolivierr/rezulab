package com.appvenir.resumehelper.domain.payRange.model;

import com.appvenir.resumehelper.domain.common.Auditable;
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
