package com.appvenir.rezulab.domain.company.mapper;

import java.util.stream.Collectors;

import com.appvenir.rezulab.domain.address.mapper.AddressMapper;
import com.appvenir.rezulab.domain.company.dto.CompanyDto;
import com.appvenir.rezulab.domain.company.model.Company;
import com.appvenir.rezulab.domain.contactNumber.mapper.ContactNumberMapper;

public class CompanyMapper {
    
    public static Company toEntity(CompanyDto companyDto)
    {
        var company = new Company();
        company.setName(companyDto.getName());
        company.setAbout(companyDto.getAbout());
        company.setAddress(AddressMapper.toEntity(companyDto.getAddress()));
        company.setContactNumbers(companyDto.getContactNumbers()
                                    .stream()
                                    .map(ContactNumberMapper::toEntity)
                                    .collect(Collectors.toList())
                                    );
        return company;
    }

    public static CompanyDto toDto(Company company)
    {
        var companyDto = new CompanyDto();
        companyDto.setName(company.getName());
        companyDto.setAbout(company.getAbout());
        companyDto.setAddress(AddressMapper.toDto(company.getAddress()));                        
        companyDto.setContactNumbers(company.getContactNumbers()
                                        .stream()
                                        .map(ContactNumberMapper::toDto)
                                        .collect(Collectors.toList())
                                    );
        return companyDto;
    }

}
