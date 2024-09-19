package com.appvenir.resumehelper.domain.contactNumber.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactNumberDto {
    
    private Long id;
    private String type;
    private String ext;
    private String number;

}
