package com.appvenir.rezulab.domain.user.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {
    
    private String fullName;

    private String email;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;

}
