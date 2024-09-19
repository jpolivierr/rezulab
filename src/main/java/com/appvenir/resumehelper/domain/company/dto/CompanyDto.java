package com.appvenir.resumehelper.domain.company.dto;

import java.util.List;

import com.appvenir.resumehelper.domain.address.dto.AddressDto;
import com.appvenir.resumehelper.domain.contactNumber.dto.ContactNumberDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto {

    private Long id;

    private String name;

    private String about;

    private AddressDto address;

    private List<ContactNumberDto> contactNumbers;
    
}
