package com.appvenir.resumehelper.domain.company.mapper;

import com.appvenir.resumehelper.domain.address.mapper.AddressMapper;
import com.appvenir.resumehelper.domain.company.dto.CompanyDto;
import com.appvenir.resumehelper.domain.company.model.Company;
import com.appvenir.resumehelper.domain.contactNumber.mapper.ContactNumberMapper;

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
                                    .toList()
                                    );
        return company;
    }

    public static CompanyDto toDto(Company company)
    {
        System.out.println("==================== ENTITY ======================");
        System.out.println(company);
        System.out.println("==================================================");
        var companyDto = new CompanyDto();
        companyDto.setName(company.getName());
        companyDto.setAbout(company.getAbout());
        companyDto.setAddress(AddressMapper.toDto(company.getAddress()));
        companyDto.setContactNumbers(company.getContactNumbers()
                                        .stream()
                                        .map(ContactNumberMapper::toDto)
                                        .toList()
                                    );
        System.out.println("==================== DTO ======================");
        System.out.println(companyDto);
        System.out.println("==================================================");
        return companyDto;
    }

}
