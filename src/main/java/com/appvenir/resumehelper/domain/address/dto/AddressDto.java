package com.appvenir.resumehelper.domain.address.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    private Long id;

    private String street;

    private String city;

    private String state;

    private String zipCode;
}
