package com.appvenir.resumehelper.domain.contactNumber.mapper;

import com.appvenir.resumehelper.domain.contactNumber.dto.ContactNumberDto;
import com.appvenir.resumehelper.domain.contactNumber.model.ContactNumber;

public class ContactNumberMapper {
    
    public static ContactNumber toEntity(ContactNumberDto contactNumberDto)
    {
        var contactNumber = new ContactNumber();
        contactNumber.setExt(contactNumberDto.getExt());
        contactNumber.setType(contactNumberDto.getType());
        contactNumber.setNumber(contactNumberDto.getNumber());
        return contactNumber;
    }

    public static ContactNumberDto toDto(ContactNumber contactNumber)
    {
        var contactNumberDto = new ContactNumberDto();
        contactNumberDto.setId(contactNumber.getId());
        contactNumberDto.setExt(contactNumber.getExt());
        contactNumberDto.setType(contactNumber.getType());
        contactNumberDto.setNumber(contactNumber.getNumber());
        return contactNumberDto;
    }

}
