package com.appvenir.resumehelper.domain.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.resumehelper.domain.user.dto.UserDto;
import com.appvenir.resumehelper.domain.user.dto.UserRegistrationDto;
import com.appvenir.resumehelper.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserDto createUser(@RequestBody UserRegistrationDto userRegistrationDto)
    {
        System.out.println(userRegistrationDto);
        return userService.saveUser(userRegistrationDto);
    }
    
}
