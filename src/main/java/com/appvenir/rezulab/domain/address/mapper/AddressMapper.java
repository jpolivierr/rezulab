package com.appvenir.rezulab.domain.address.mapper;

import com.appvenir.rezulab.domain.address.dto.AddressDto;
import com.appvenir.rezulab.domain.address.model.Address;

public class AddressMapper {
    
    public static AddressDto toDto(Address address)
    {
        var addressDto = new AddressDto();
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }

    public static Address toEntity(AddressDto addressDto)
    {
        var address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setZipCode(addressDto.getZipCode());
        return address;
    }

}
