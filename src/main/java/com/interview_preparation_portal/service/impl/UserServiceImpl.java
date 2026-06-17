package com.interview_preparation_portal.service.impl;

import com.interview_preparation_portal.dto.AuthResponse;
import com.interview_preparation_portal.dto.LoginRequest;
import com.interview_preparation_portal.dto.RegisterRequest;
import com.interview_preparation_portal.entity.User;
import com.interview_preparation_portal.repository.UserRepository;
import com.interview_preparation_portal.security.JwtUtil;
import com.interview_preparation_portal.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl
        implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.userRepository =
                userRepository;

        this.passwordEncoder =
                passwordEncoder;

        this.jwtUtil =
                jwtUtil;
    }

    @Override
    public User register(
            RegisterRequest request) {

        if(userRepository.existsByEmail(
                request.getEmail())) {

            throw new RuntimeException(
                    "Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(

                passwordEncoder.encode(

                        request.getPassword()
                )
        );

        return userRepository.save(user);
    }

    @Override
    public AuthResponse login(
            LoginRequest request) {

        User user =
                userRepository
                        .findByEmail(
                                request.getEmail()
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User Not Found"));

        if (!passwordEncoder.matches(

                request.getPassword(),

                user.getPassword()

        )) {

            throw new RuntimeException(
                    "Invalid Password");
        }

        String token =
                jwtUtil.generateToken(
                        user.getEmail()
                );

        return new AuthResponse(

                token,

                user.getId(),

                user.getName()
        );
    }
}