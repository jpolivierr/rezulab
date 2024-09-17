package com.appvenir.resumehelper.domain.company.dto;

import com.appvenir.resumehelper.domain.address.model.Address;
import com.appvenir.resumehelper.domain.contactNumber.dto.ContactNumberDto;

import lombok.Data;

@Data
public class CompanyDto {

    private Long id;

    private String name;

    private String about;

    private Address address;

    private ContactNumberDto contactNumber;
    
}
