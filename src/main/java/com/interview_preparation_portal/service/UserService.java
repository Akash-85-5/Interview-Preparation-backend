package com.interview_preparation_portal.service;

import com.interview_preparation_portal.dto.AuthResponse;
import com.interview_preparation_portal.dto.LoginRequest;
import com.interview_preparation_portal.dto.RegisterRequest;
import com.interview_preparation_portal.entity.User;

public interface UserService {

    User register(RegisterRequest request);

    AuthResponse login(
            LoginRequest request);
}
