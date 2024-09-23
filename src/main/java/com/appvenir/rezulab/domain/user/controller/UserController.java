package com.appvenir.rezulab.domain.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.appvenir.rezulab.domain.user.dto.UserDto;
import com.appvenir.rezulab.domain.user.dto.UserRegistrationDto;
import com.appvenir.rezulab.domain.user.service.UserService;
import com.appvenir.rezulab.http.ResponseData;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseData<UserDto> createUser(@RequestBody UserRegistrationDto userRegistrationDto)
    {
        var user = userService.saveUser(userRegistrationDto);
        return ResponseData.set(user);
    }
    
}
