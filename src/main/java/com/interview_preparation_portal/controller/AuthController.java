package com.interview_preparation_portal.controller;

import com.interview_preparation_portal.dto.AuthResponse;
import com.interview_preparation_portal.dto.LoginRequest;
import com.interview_preparation_portal.dto.RegisterRequest;
import com.interview_preparation_portal.entity.User;
import com.interview_preparation_portal.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;

    public AuthController(
            UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(
            @RequestBody RegisterRequest request) {

        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        return userService.login(
                request
        );
    }
}