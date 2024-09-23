package com.appvenir.rezulab.domain.payRange.mapper;

import com.appvenir.rezulab.domain.payRange.dto.PayRangeDto;
import com.appvenir.rezulab.domain.payRange.model.PayRange;

public class PayRangeMapper {
 
    public static PayRange toEntity(PayRangeDto payrangeDto)
    {
        var payRange = new PayRange();
        payRange.setMin(payrangeDto.getMin());
        payRange.setMax(payrangeDto.getMax());
        payRange.setPeriod(payrangeDto.getPeriod());
        return payRange;
    }

    public static PayRangeDto toDto(PayRange payRange)
    {
        var payRangeDto = new PayRangeDto();
        payRangeDto.setMin(payRange.getMin());
        payRangeDto.setMax(payRange.getMax());
        payRangeDto.setPeriod(payRange.getPeriod());
        return payRangeDto;
    }
    
}
