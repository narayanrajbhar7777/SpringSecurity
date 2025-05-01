package com.spring.security.service;

import com.spring.security.model.Users;
import com.spring.security.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final JWTService jwtService;

    private final AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    private final UserRepo repo;

    public UsersService(JWTService jwtService, AuthenticationManager authManager, UserRepo repo) {
        this.jwtService = jwtService;
        this.authManager = authManager;
        this.repo = repo;
    }



    public Users register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return user;
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername());
        } else {
            return "fail";
        }
    }
}