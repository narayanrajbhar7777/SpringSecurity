package com.spring.security.controller;

import com.spring.security.model.Users;
import com.spring.security.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private final UsersService service;
    public UsersController(UsersService service){
        this.service=service;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return service.verify(user);
    }
}