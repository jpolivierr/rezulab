package com.appvenir.resumehelper.domain.payRange.dto;

import lombok.Data;

@Data
public class PayRangeDto {
    private Long id;
    private Integer min;
    private Integer max;
    private String period;
}
