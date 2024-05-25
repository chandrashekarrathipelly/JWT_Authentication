package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserDto;
import com.example.demo.entites.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/public")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
        return userService.login(userDto);
    }

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.createUser(user);
    }



}
