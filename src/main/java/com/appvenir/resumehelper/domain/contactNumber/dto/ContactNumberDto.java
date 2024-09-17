package com.appvenir.resumehelper.domain.contactNumber.dto;

import lombok.Data;

@Data
public class ContactNumberDto {
    
    private Long id;
    private String type;
    private String ext;
    private String number;

}
