package com.appvenir.resumehelper.domain.user.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {
    
    private String name;

    private String email;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;

}
