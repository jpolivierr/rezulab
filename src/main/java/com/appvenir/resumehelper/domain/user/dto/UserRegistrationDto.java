package com.appvenir.resumehelper.domain.user.dto;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserRegistrationDto {

    private String fullName;

    private String email;

    private String password;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;
    
}
