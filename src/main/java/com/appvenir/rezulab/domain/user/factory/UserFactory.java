package com.appvenir.rezulab.domain.user.factory;

import java.time.LocalDateTime;

import com.appvenir.rezulab.domain.user.model.User;

public class UserFactory {
    
    public static User getUser()
    {
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setEmail("someemail@gmail.com");
        user.setFullName("John Wick");
        user.setPassword("somepassword");
        user.setDateCreated(LocalDateTime.now());
        user.setLastUpdated(LocalDateTime.now());
        return user;
    }

}
